package com.springcloud.rcba.web.role;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.rcba.service.role.ITRoleService;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TRoleController", description = "")
@RestController
@RequestMapping("/t-role")
public class TRoleController {
    private static Logger logger = LoggerFactory.getLogger(TRoleController.class);

    @Autowired
    private ITRoleService service;


}
