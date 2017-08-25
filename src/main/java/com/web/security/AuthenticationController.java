package com.web.security;

import com.domain.request.JwtAuthenticationReq;
import com.domain.response.TokenRes;
import com.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "Authentication")
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<TokenRes> createAuthenticationToken(@Valid @ModelAttribute JwtAuthenticationReq authenticationRequest, HttpServletRequest httpServletRequest) throws AuthenticationException {

        // Perform the security
        String username = authenticationRequest.getUsername();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException(username);
        }

        // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
        // the database compellingly. Again it's up to you ;)
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        LOGGER.info("authenticated user {}, setting security context", username);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final String token = jwtTokenUtil.generateToken(username);
        LOGGER.info("username:{},token:{}", username, token);
        // Return the token
        return ResponseEntity.ok(new TokenRes(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<TokenRes> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = jwtTokenUtil.getUsernameFromToken(authorization);
        return ResponseEntity.ok(new TokenRes(jwtTokenUtil.generateToken(username)));
    }

}