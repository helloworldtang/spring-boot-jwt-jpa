package com.global.filter;

import com.alibaba.fastjson.JSON;
import com.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        /**
         * Whenever the user wants to access a protected route or resource,
         * the user agent should send the JWT,
         * typically in the Authorization header using the Bearer schema.
         * The content of the header should look like the following:
         * Authorization: Bearer <token>
         * This is a stateless authentication mechanism as the user state is never saved in server memory.
         * The server's protected routes will check for a valid JWT in the Authorization header,
         * and if it's present, the user will be allowed to access protected resources.
         */
        // authToken.startsWith("Bearer ")
        // String authToken = header.substring(7);
        if (StringUtils.isBlank(authorization)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        try {
            String username = jwtTokenUtil.getUsernameFromToken(authorization);
            LOGGER.info("checking authentication for user:{},uri:{}", username, httpServletRequest.getRequestURI());

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {//服务器重启的场景

                // It is not compelling necessary to load the use details from the database. You could also store the information
                // in the token and read it from it. It's up to you ;)
                //validateToken的逻辑中，就需要判断username是否存在和过期时间
                //查出来UserDetails类型的数据是因为UsernamePasswordAuthenticationToken对象会使用
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
                // the database compellingly. Again it's up to you ;)
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                LOGGER.info("authenticated user {}, setting security context", username);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            try (PrintWriter out = httpServletResponse.getWriter()) {
                out.write(JSON.toJSONString("unauthorized"));
                out.flush();
            }
        }

    }
}