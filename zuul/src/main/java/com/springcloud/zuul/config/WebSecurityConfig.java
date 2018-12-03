package com.springcloud.zuul.config;

import com.springcloud.zuul.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("**/oauth/token","**/oauth/authorize","**/oauth/check_token","**/oauth/confirm_access","**/oauth/error")
                .permitAll()
                .and().addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserService();
    }
}
