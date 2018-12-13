package com.springcloud.zuul.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("rcba")
public interface RcbaUserService {

    @RequestMapping(value = "/t-user/loadCustomUserDetailsByUsername", method = RequestMethod.POST)
    CustomUserDetails loadUserByUsername(String username);
}
