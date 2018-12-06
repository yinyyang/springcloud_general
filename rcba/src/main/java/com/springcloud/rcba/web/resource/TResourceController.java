package com.springcloud.rcba.web.resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.rcba.service.resource.ITResourceService;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TResourceController", description = "")
@RestController
@RequestMapping("/t-resource")
public class TResourceController {
    private static Logger logger = LoggerFactory.getLogger(TResourceController.class);

	@Autowired
    private ITResourceService service;


}
