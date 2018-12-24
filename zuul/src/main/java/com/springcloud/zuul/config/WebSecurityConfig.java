package com.springcloud.zuul.config;

import com.springcloud.zuul.authentication.Oauth2JwtTokenAuthenticationProcessingFilter;
import com.springcloud.zuul.authorization.CustomSecurityInterceptorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Order(200)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSecurityInterceptorFilter customSecurityInterceptorFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/auth/**")
                .permitAll()
                .and()
                .addFilterBefore(new Oauth2JwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(customSecurityInterceptorFilter, FilterSecurityInterceptor.class);
    }

}
