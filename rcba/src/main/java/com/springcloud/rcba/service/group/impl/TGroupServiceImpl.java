package com.springcloud.rcba.service.group.impl;

import com.springcloud.rcba.model.group.TGroup;
import com.springcloud.rcba.mapper.group.TGroupMapper;
import com.springcloud.rcba.service.group.ITGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


@Service
public class TGroupServiceImpl extends ServiceImpl<TGroupMapper, TGroup> implements ITGroupService {
 private static Logger logger = LoggerFactory.getLogger(TGroupServiceImpl.class);

    @Resource
    private TGroupMapper dao;
}
