package com.springcloud.rcba.service.user;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface ITUserService extends IService<TUser> {
    public CustomUserDetails loadCustomUserDetailsByUsername(String username);

}
