package com.xxuan.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2024-03-27 20:15:39
 */

public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    boolean checkUserNameUnique(String userName);

    boolean checkPhoneUnique(User user);

    boolean checkEmailUnique(User user);

    ResponseResult addUser(User user);

    void updateUser(User user);
}