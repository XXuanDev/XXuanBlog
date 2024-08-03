package com.xxuan.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.Comment;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2024-03-27 15:04:20
 */

public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
