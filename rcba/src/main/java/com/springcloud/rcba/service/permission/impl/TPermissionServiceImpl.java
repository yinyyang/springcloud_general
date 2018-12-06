package com.springcloud.rcba.service.permission.impl;

import com.springcloud.rcba.model.permission.TPermission;
import com.springcloud.rcba.mapper.permission.TPermissionMapper;
import com.springcloud.rcba.service.permission.ITPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


@Service
public class TPermissionServiceImpl extends ServiceImpl<TPermissionMapper, TPermission> implements ITPermissionService {
 private static Logger logger = LoggerFactory.getLogger(TPermissionServiceImpl.class);

    @Resource
    private TPermissionMapper dao;
}
