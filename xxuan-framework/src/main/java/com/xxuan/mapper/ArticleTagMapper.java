package com.xxuan.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章标签关联表(ArticleTag)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-09 10:08:28
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
}
