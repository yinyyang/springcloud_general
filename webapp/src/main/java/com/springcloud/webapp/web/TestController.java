package com.springcloud.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("info")
    @ResponseBody
    public String getInfo(){
        return "call info successful by resource server!";
    }
}
