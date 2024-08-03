package com.xxuan.service;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.User;

/**
 * @ClassName: BlogLoginService
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 14:13
 * @Version: V1.0
 */
public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
