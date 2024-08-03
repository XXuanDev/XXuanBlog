package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.LoginUser;
import com.xxuan.domain.entity.Menu;
import com.xxuan.domain.entity.User;
import com.xxuan.domain.vo.AdminUserInfoVo;
import com.xxuan.domain.vo.RoutersVo;
import com.xxuan.domain.vo.UserInfoVo;
import com.xxuan.enums.AppHttpCodeEnum;
import com.xxuan.exception.SystemException;
import com.xxuan.service.LoginService;
import com.xxuan.service.MenuService;
import com.xxuan.service.RoleService;
import com.xxuan.utils.BeanCopyUtils;
import com.xxuan.utils.RedisCache;
import com.xxuan.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-04-01 11:08
 * @Version: V1.0
 */

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisCache redisCache;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }


    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo() {
        //获取当前登录的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        //封装数据返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms, roleKeyList, userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    @GetMapping("/getRouters")
    public ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果是tree的形式
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装数据返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }
}
