package com.springcloud.rcba.service.role.impl;

import com.springcloud.rcba.model.role.TRole;
import com.springcloud.rcba.mapper.role.TRoleMapper;
import com.springcloud.rcba.service.role.ITRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {
    private static Logger logger = LoggerFactory.getLogger(TRoleServiceImpl.class);

    @Resource
    private TRoleMapper dao;
}
