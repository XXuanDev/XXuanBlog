package com.xxuan.domain.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: TagListDto
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-04-08 20:14
 * @Version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagListDto {

    private String name;
    private String remark;
}
