package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.User;
import com.xxuan.enums.AppHttpCodeEnum;
import com.xxuan.exception.SystemException;
import com.xxuan.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: BlogLoginController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 13:29
 * @Version: V1.0
 */

@RestController
@RequestMapping
public class BlogLoginController {

    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        if (!StringUtils.hasText(user.getUserName())){
            //提示必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
