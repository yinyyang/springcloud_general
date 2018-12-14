package com.springcloud.rcba.mapper.user;

import com.springcloud.rcba.model.user.CustomUserDetails;
import com.springcloud.rcba.model.user.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    List<String> loadCustomUserDetailsByUsername(String username);

    TUser loadUserByUsername(String username);
}
