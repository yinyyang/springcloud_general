package com.springcloud.rcba.service.user.impl;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.springcloud.rcba.mapper.user.TUserMapper;
import com.springcloud.rcba.service.user.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
 private static Logger logger = LoggerFactory.getLogger(TUserServiceImpl.class);

    @Resource
    private TUserMapper dao;

    @Override
    public CustomUserDetails loadCustomUserDetailsByUsername(String username) {
        return dao.loadCustomUserDetailsByUsername(username);
    }
}
