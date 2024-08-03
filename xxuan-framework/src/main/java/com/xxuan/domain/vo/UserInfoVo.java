package com.xxuan.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: UserInfoVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 20:47
 * @Version: V1.0
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar;
    private String sex;
    private String email;
}