package com.xxuan.service.impl;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.LoginUser;
import com.xxuan.domain.entity.User;
import com.xxuan.service.LoginService;
import com.xxuan.utils.JwtUtil;
import com.xxuan.utils.RedisCache;
import com.xxuan.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName: BlogLoginServiceImpl
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 14:14
 * @Version: V1.0
 */

@Service
public class SystemLoginServiceImpl implements LoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        LoginUser loginUser = (LoginUser) userDetailsService.loadUserByUsername(user.getUserName());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId); //到这步代码报错
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);

        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);
    }

    @Override
    public ResponseResult logout() {
        //获取当前登录用户id
        Long userId = SecurityUtils.getUserId();
        //删除redis中对应的值
        redisCache.deleteObject("login:"+userId);
        return ResponseResult.okResult();
    }
}
