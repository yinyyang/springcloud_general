package com.springcloud.zuul.permission;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {


    public List<Permission> findAll(){

        List<Permission> list = new ArrayList<>();
        Permission p = new Permission();
        p.setName("a");
        p.setUrl("/resource/order");
        list.add(p);
        return list;
    }
}
