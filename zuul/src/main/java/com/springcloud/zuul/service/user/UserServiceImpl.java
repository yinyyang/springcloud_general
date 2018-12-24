package com.springcloud.zuul.service.user;

import com.springcloud.zuul.feign.RcbaRemoteService;
import com.springcloud.zuul.model.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{

 @Autowired
 private RcbaRemoteService rcbaRemoteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       CustomUserDetails customUserDetails = rcbaRemoteService.loadUserByUsername(username);


        if (customUserDetails.getAuthorities() != null) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (String permission: customUserDetails.getAuthorities()) {
                if (permission != null && permission != null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(username, "", grantedAuthorities) {
            };
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }


}