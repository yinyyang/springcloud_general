package com.springcloud.rcba.mapper.permission;

import com.springcloud.rcba.model.permission.CustomPermissionDetails;
import com.springcloud.rcba.model.permission.TPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TPermissionMapper extends BaseMapper<TPermission> {

    List<CustomPermissionDetails> loadAllCustomPermissionDetails();
}
