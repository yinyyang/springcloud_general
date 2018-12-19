package com.springcloud.zuul.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.zuul.user.UserServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Oauth2JwtTokenAuthenticationProcessingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(sc);
        UserServiceImpl userService = (UserServiceImpl) webCtx.getBean("userServiceImpl");
        String authorization = request.getHeader("Authorization");
        String  token = request.getHeader("accessToken");
        String tokenType  =  request.getHeader("tokenType");
        if (token != null) {
            Jwt jwt = JwtHelper.decode(token);
            ObjectMapper mapper = new ObjectMapper();
            Map mapTypes = mapper.readValue(jwt.getClaims(),Map.class);
            Object username = mapTypes.get("user_name");
            if(username !=null) {
                UserDetails userDetails = userService.loadUserByUsername((String)username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

}
