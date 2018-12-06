package com.springcloud.rcba.service.resource.impl;

import com.springcloud.rcba.model.resource.TResource;
import com.springcloud.rcba.mapper.resource.TResourceMapper;
import com.springcloud.rcba.service.resource.ITResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


@Service
public class TResourceServiceImpl extends ServiceImpl<TResourceMapper, TResource> implements ITResourceService {
 private static Logger logger = LoggerFactory.getLogger(TResourceServiceImpl.class);

    @Resource
    private TResourceMapper dao;
}
