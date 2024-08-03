package com.xxuan.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: ArticleDetailVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-24 19:52
 * @Version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {
    private Long id;
    private String title;
    private String summary;
    private Long categoryId;
    private String categoryName;
    private String thumbnail;
    private String content;
    private Long viewCount;
    private Date createTime;

}
