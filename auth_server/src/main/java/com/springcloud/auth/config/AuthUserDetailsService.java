package com.springcloud.auth.config;

import com.springcloud.auth.feign.RcbaRemoteService;
import com.springcloud.auth.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserDetailsService   implements UserDetailsService {

    @Autowired
    private RcbaRemoteService rcbaRemoteService;
    //用户其它验证可以写到这里
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = rcbaRemoteService.loadCustomUserDetailsByUsername(username);


        if (customUserDetails.getAuthorities() != null) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList();
            for (String permission: customUserDetails.getAuthorities()) {
                if (permission != null && permission != null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(username, customUserDetails.getPassword(), grantedAuthorities) {
            };
        } else {
            throw new UsernameNotFoundException( username + " do not exist!");
        }
    }



}

