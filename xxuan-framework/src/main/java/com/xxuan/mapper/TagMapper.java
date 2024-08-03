package com.xxuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-01 09:51:58
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
