package com.springcloud.resource.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControlller {

    @RequestMapping("order")
    public String order(){
        return "order";
    }
}
