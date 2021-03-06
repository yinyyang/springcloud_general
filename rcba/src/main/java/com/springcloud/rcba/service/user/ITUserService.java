package com.springcloud.rcba.service.user;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ITUserService extends IService<TUser> {
    public CustomUserDetails loadCustomUserDetailsByUsername(String username);

    public TUser loadUserByUsername(String username);
}
