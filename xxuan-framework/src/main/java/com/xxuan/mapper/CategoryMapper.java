package com.xxuan.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分类表(Category)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-21 09:19:30
 */

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
