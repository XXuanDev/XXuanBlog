package com.xxuan.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: BlogUserLoginVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 20:46
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {
    private String token;
    private UserInfoVo userInfo;
}