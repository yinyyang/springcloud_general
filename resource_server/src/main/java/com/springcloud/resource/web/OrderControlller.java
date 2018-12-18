package com.springcloud.resource.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OrderControlller {

    @RequestMapping("order")
    public String order(Principal principal) throws Exception {
        //int a=2/0;
        return "order:" + principal;
    }
}
