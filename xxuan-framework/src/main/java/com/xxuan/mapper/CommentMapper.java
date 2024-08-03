package com.xxuan.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论表(Comment)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-27 15:04:18
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
