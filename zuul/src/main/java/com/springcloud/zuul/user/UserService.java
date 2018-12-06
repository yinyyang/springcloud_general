package com.springcloud.zuul.user;

import com.springcloud.zuul.permission.Permission;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =new User();
        user.setUsername("test");
        user.setPassword("$2a$10$CLEjqO6pudd3Bb1fBI1hz.PZvqVjB84fidq/31hvQZnO/6v0cGIp.");
        List<Permission> list = new ArrayList<>();
        Permission p = new Permission();
        p.setName("a");
        p.setUrl("/resource/order");
        list.add(p);
        if (user != null) {

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : list) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities) {
            };
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }


    }