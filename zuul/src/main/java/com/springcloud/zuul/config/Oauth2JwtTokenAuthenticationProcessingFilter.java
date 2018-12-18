package com.springcloud.zuul.config;

import com.alibaba.fastjson.JSON;
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
    private UserServiceImpl  userService;


//    public void init(FilterConfig filterConfig) throws ServletException{
//         SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                 filterConfig.getServletContext());
//        ServletContext sc = this.getServletContext();
//        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
//
//        if(cxt != null && cxt.getBean("userServiceImpl") != null && userService == null)
//            userService = (UserServiceImpl) cxt.getBean("userServiceImpl");
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(sc);
        UserServiceImpl userService = (UserServiceImpl) webCtx.getBean("userServiceImpl");
        String  token = request.getHeader("accessToken");
        String tokenType  =  request.getHeader("tokenType");
        if (token != null) {
            Jwt jwt = JwtHelper.decode(token);
            Map mapTypes = JSON.parseObject(jwt.getClaims());
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
