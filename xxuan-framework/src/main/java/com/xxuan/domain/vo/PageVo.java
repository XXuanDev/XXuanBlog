package com.xxuan.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: PageVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-21 15:17
 * @Version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
