package com.springcloud.rcba.web.permission;


import com.springcloud.rcba.model.permission.CustomPermissionDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.rcba.service.permission.ITPermissionService;

import java.util.List;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TPermissionController", description = "")
@RestController
@RequestMapping("/t-permission")
public class TPermissionController {
    private static Logger logger = LoggerFactory.getLogger(TPermissionController.class);

    @Autowired
    private ITPermissionService service;

    @RequestMapping("loadAllCustomPermissionDetails")
    public List<CustomPermissionDetails> loadAllCustomPermissionDetails(){
        return service.loadAllCustomPermissionDetails();
    }


}
