package com.springcloud.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class AuthUserDetailsService extends JdbcUserDetailsManager {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private DataSource datasource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }

        return userDetails;
    }

    @Autowired
    public void setDatasource(DataSource datasource) {
        super.setDataSource(this.datasource);
    }
}

