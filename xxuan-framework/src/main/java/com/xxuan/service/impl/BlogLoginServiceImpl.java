package com.xxuan.service.impl;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.LoginUser;
import com.xxuan.domain.entity.User;
import com.xxuan.domain.vo.BlogUserLoginVo;
import com.xxuan.domain.vo.UserInfoVo;
import com.xxuan.service.BlogLoginService;
import com.xxuan.utils.BeanCopyUtils;
import com.xxuan.utils.JwtUtil;
import com.xxuan.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @ClassName: BlogLoginServiceImpl
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 14:14
 * @Version: V1.0
 */

@Service
public class BlogLoginServiceImpl implements BlogLoginService {

//    @Autowired
//    private UserDetailsService userDetailsService;

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
        redisCache.setCacheObject("bloglogin"+userId,loginUser);

        /**
         * 把userinfo和token封装 返回
         */
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);

        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(blogUserLoginVo);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userId
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userId
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject("bloglogin"+userId);
        return ResponseResult.okResult();
    }
}
