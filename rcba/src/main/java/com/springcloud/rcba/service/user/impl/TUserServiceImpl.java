package com.springcloud.rcba.service.user.impl;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.springcloud.rcba.mapper.user.TUserMapper;
import com.springcloud.rcba.service.user.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    private static Logger logger = LoggerFactory.getLogger(TUserServiceImpl.class);

    @Resource
    private TUserMapper dao;

    @Override
    public CustomUserDetails loadCustomUserDetailsByUsername(String username) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        List<String> authorities = dao.loadCustomUserDetailsByUsername(username);
        if (authorities.isEmpty()) {
            return null;
        } else {
            customUserDetails.setUsername(username);
            customUserDetails.setAuthorities(authorities);
            return customUserDetails;
        }
    }

}
