package com.springcloud.zuul.service.permission;

import com.springcloud.zuul.feign.RcbaRemoteService;
import com.springcloud.zuul.model.permission.CustomPermissionDetails;
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
