package com.springcloud.rcba.web.user;


import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.rcba.service.user.ITUserService;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TUserController", description = "")
@RestController
@RequestMapping("/t-user")
public class TUserController {
    private static Logger logger = LoggerFactory.getLogger(TUserController.class);

    @Autowired
    private ITUserService service;

    @RequestMapping("/loadCustomUserDetailsByUsername")
    public CustomUserDetails loadCustomUserDetailsByUsername(String username) {
        return service.loadCustomUserDetailsByUsername(username);
    }

    @RequestMapping("/loadUserByUsername")
    public TUser loadUserByUsername(String username) {
        return service.loadUserByUsername(username);
    }
}
