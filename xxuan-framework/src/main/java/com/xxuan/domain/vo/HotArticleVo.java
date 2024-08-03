package com.xxuan.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: HotArticleVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-20 22:35
 * @Version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    private Long id;
    private String title;    //标题
    private Long viewCount;    //访问量
}