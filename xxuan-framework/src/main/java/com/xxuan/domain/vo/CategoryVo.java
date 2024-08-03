package com.xxuan.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CategoryVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-21 14:30
 * @Version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {
    private Long id;
    private String name;
    //描述
    private String description;
}
