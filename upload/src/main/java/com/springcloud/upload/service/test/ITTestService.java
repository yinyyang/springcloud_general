package com.springcloud.upload.service.test;

import com.springcloud.upload.model.test.TTest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface ITTestService extends IService<TTest> {

    boolean customInsert(Map map);
    List<Map> customSelect(Map map);

}
