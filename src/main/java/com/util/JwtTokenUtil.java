package com.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenUtil implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String ISSUER = "1gepingguo";
    private static final String AUDIENCE = "app";

    private String secret = "!T6RvbbYv1jp!nwk";

    public String getUsernameFromToken(String authorization) {
        try {
            String authToken = authorization.substring(7);
            return getClaimsFromToken(authToken)
                    .getSubject();
        } catch (Exception e) {
            LOGGER.warn("token:{}", authorization, e.getMessage(), e);
            throw new BadCredentialsException(e.getMessage());
        }

    }


    public String generateToken(String userName) {
        return generateToken(userName, LocalDateTime.now().plusHours(12).toDate());
    }


    public String generateToken(String userName, Date expire) {
        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(expire)
                .setIssuedAt(new Date())
                .setIssuer(ISSUER)
                .setAudience(AUDIENCE)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return generateToken(claims.getSubject());
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .requireIssuer(ISSUER)
                .requireAudience(AUDIENCE)
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}