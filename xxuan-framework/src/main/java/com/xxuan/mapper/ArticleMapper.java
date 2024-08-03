package com.xxuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: ArticleMapper
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-20 16:15
 * @Version: V1.0
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
