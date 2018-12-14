package com.springcloud.rcba.service.permission;

import com.springcloud.rcba.model.permission.CustomPermissionDetails;
import com.springcloud.rcba.model.permission.TPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ITPermissionService extends IService<TPermission> {

    List<CustomPermissionDetails> loadAllCustomPermissionDetails();
}
