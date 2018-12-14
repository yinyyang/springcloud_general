package com.springcloud.zuul.permission;

import com.springcloud.zuul.feign.RcbaRemoteService;
import com.springcloud.zuul.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private RcbaRemoteService rcbaRemoteService;

    public List<CustomPermissionDetails> findAll() {

       return rcbaRemoteService.loadAllCustomPermissionDetails();
    }
}
