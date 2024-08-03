package com.xxuan.service;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}