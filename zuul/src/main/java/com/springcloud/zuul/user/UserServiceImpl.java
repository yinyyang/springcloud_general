package com.springcloud.zuul.user;

import com.springcloud.zuul.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{

 @Resource
 private RcbaUserService rcbaUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       CustomUserDetails customUserDetails = rcbaUserService.loadUserByUsername(username);


        if (customUserDetails.getAuthorities() != null) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (String permission: customUserDetails.getAuthorities()) {
                if (permission != null && permission != null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(username, null, grantedAuthorities) {
            };
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }


}