package com.springcloud.rcba.web.group;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.rcba.service.group.ITGroupService;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TGroupController", description = "")
@RestController
@RequestMapping("/t-group")
public class TGroupController {
    private static Logger logger = LoggerFactory.getLogger(TGroupController.class);

	@Autowired
    private ITGroupService service;


}
