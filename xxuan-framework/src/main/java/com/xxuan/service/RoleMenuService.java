package com.xxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.entity.RoleMenu;

public interface RoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenuByRoleId(Long id);
}