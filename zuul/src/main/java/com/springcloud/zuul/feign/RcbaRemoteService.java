package com.springcloud.zuul.feign;

import com.springcloud.zuul.config.FeignConfig;
import com.springcloud.zuul.model.permission.CustomPermissionDetails;
import com.springcloud.zuul.model.user.CustomUserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="rcba",configuration = FeignConfig.class)
public interface RcbaRemoteService {

    //这里的写法需要非常规范，不能像一般contorller一样的写法，不然可能参数传不进去
    @RequestMapping(value = "/t-user/loadCustomUserDetailsByUsername", method = RequestMethod.POST)
    CustomUserDetails loadUserByUsername(@RequestParam("username") String username);

    //这里的写法需要非常规范，不能像一般contorller一样的写法，不然可能参数传不进去
    @RequestMapping(value = "/t-permission/loadAllCustomPermissionDetails", method = RequestMethod.POST)
    List<CustomPermissionDetails> loadAllCustomPermissionDetails();
}
