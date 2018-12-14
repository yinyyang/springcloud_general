package com.springcloud.auth.feign;


import com.springcloud.auth.config.FeignConfig;
import com.springcloud.auth.user.CustomUserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="rcba",configuration = FeignConfig.class)
public interface RcbaRemoteService {

    //这里的写法需要非常规范，不能像一般contorller一样的写法，不然可能参数传不进去
    @RequestMapping(value = "/t-user/loadCustomUserDetailsByUsername", method = RequestMethod.POST)
    CustomUserDetails loadCustomUserDetailsByUsername(@RequestParam("username") String username);

}
