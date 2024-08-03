package com.xxuan.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * 友链(Link)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-25 09:03:17
 */

@Mapper
public interface LinkMapper extends BaseMapper<Link> {
}
