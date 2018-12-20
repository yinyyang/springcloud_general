package com.springcloud.resource.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
public class OrderControlller {

    @RequestMapping(value = "order",method = RequestMethod.POST)
    public String order(Principal principal) throws Exception {
        //int a=2/0;
        return "order:" + principal;
    }

    @RequestMapping(value = "date",method = RequestMethod.POST)
    public String date(Date date) throws Exception {

        return "order:" + date;
    }
}
