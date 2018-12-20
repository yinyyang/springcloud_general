package com.springcloud.resource.web.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.springcloud.resource.ajax.APIResponse;
import com.springcloud.resource.helper.AssertHelper;
import com.springcloud.resource.model.test.TTest;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springcloud.resource.service.test.ITTestService;

import java.util.List;
import java.util.Map;


// swagger address
// http://localhost:8080/swagger-ui.html
@Api(value = "API - TTestController", description = "")
@RestController
@RequestMapping("test")
public class TTestController {
    private static Logger logger = LoggerFactory.getLogger(TTestController.class);

	@Autowired
    private ITTestService service;

    @RequestMapping(value = "getPage",method = RequestMethod.POST)
	public APIResponse  getPage(@RequestBody Map map) throws Exception{
        Integer currentPage = (Integer)map.get("page");
        Integer pageSize = (Integer)map.get("pageSize");
        if (currentPage != null && pageSize != null) {
            PageHelper.startPage(currentPage, pageSize);
        }else{

            APIResponse.fail("current page or page size is null!");
        }

        QueryWrapper<TTest> wrapper = new QueryWrapper<>();

        //name
        Object name = map.get("name");
        if(AssertHelper.isNotEmpty(name)){
                 wrapper.like("name",name);
        }
        wrapper.orderByDesc("id");
        List<TTest> list= service.list(wrapper);
        APIResponse apiResponse = APIResponse.success(list);

        return apiResponse;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public APIResponse add(@RequestBody TTest tTest) throws  Exception{

       //name
        Object name = tTest.getName();
        if(AssertHelper.isEmpty(name)){
            APIResponse.fail("name can't be null！");
        }

        boolean flag = service.save(tTest);

        return APIResponse.withCode(flag);

    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public APIResponse update(@RequestBody TTest tTest) throws  Exception{

        //id
        Object id = tTest.getId();
        if(AssertHelper.isEmpty(id)){
            APIResponse.fail("id can't be null！");
        }

        //name
        Object name = tTest.getName();
        if(AssertHelper.isEmpty(name)){
            APIResponse.fail("name can't be null！");
        }

        boolean flag = service.updateById(tTest);

        return APIResponse.withCode(flag);

    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public APIResponse delete(@RequestBody Integer id) throws  Exception{

        //id
        if(AssertHelper.isEmpty(id)){
            APIResponse.fail("name can't be null！");
        }

        boolean flag = service.removeById(id);

        return APIResponse.withCode(flag);

    }

}
