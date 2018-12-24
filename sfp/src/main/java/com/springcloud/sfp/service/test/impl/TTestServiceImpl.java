package com.springcloud.sfp.service.test.impl;

import com.springcloud.sfp.helper.AssertHelper;
import com.springcloud.sfp.model.test.TTest;
import com.springcloud.sfp.mapper.test.TTestMapper;
import com.springcloud.sfp.service.test.ITTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TTestServiceImpl extends ServiceImpl<TTestMapper, TTest> implements ITTestService {
 private static Logger logger = LoggerFactory.getLogger(TTestServiceImpl.class);

    @Resource
    private TTestMapper dao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean customInsert(Map map) {
        return false;
    }

    @Override
    public List<Map> customSelect(Map map) {
        Map param = new HashMap<>();
        StringBuffer where = new StringBuffer();
        //id
        Object id = map.get("id");
        if(AssertHelper.isNotEmpty(id)) {
            param.put("id", id);
            where.append(" and t.id = #{id} ");
        }

        String sql = "select " +
                "t.id as id," +
                "t.name as name," +
                "t.descript as descript " +
                "t_test t where 1 = 1 " +
                where +
                " order by t.id desc";
        param.put("sql",sql);
        return dao.selectByMap(param);
    }
}
