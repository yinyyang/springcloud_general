package com.springcloud.resource.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OrderControlller {

    @RequestMapping("order")
    public String order(Principal principal){
        return "order:"+principal;
    }
}
