package com.springcloud.rcba.service.user.impl;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.springcloud.rcba.mapper.user.TUserMapper;
import com.springcloud.rcba.service.user.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    private static Logger logger = LoggerFactory.getLogger(TUserServiceImpl.class);

    @Resource
    private TUserMapper dao;

    @Override
    public CustomUserDetails loadCustomUserDetailsByUsername(String username) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        TUser user = dao.loadUserByUsername(username);
        if (!StringUtils.isEmpty(user)) {
            customUserDetails.setUsername(user.getUsername());
            customUserDetails.setPassword(user.getPassword());
            List<String> authorities = dao.loadCustomUserDetailsByUsername(username);
            if (!authorities.isEmpty()) {
                customUserDetails.setAuthorities(authorities);
            }
        }
        return customUserDetails;
    }
    @Override
    public TUser loadUserByUsername(String username) {
        return dao.loadUserByUsername(username) ;
    }

}
