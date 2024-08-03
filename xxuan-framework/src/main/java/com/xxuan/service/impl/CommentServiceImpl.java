package com.xxuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxuan.constants.SystemConstants;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.Comment;
import com.xxuan.domain.vo.CommentVo;
import com.xxuan.domain.vo.PageVo;
import com.xxuan.enums.AppHttpCodeEnum;
import com.xxuan.exception.SystemException;
import com.xxuan.mapper.CommentMapper;
import com.xxuan.service.CommentService;
import com.xxuan.service.UserService;
import com.xxuan.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-03-27 15:06:34
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize) {
        //查询对应文章的根评论

        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //对articleId进行判断
        lambdaQueryWrapper.eq(SystemConstants.ARTICLE_COMMENT.equals(commentType),Comment::getArticleId, articleId);
        //根评论rootId为-1
        lambdaQueryWrapper.eq(Comment::getRootId, -1);
        lambdaQueryWrapper.orderByAsc(Comment::getCreateTime);

        //评论类型
        lambdaQueryWrapper.eq(Comment::getType,commentType);

        //分页查询
        Page<Comment> commentPage = new Page<>(pageNum, pageSize);
        page(commentPage, lambdaQueryWrapper);

        List<CommentVo> commentVoList = toComentVoList(commentPage.getRecords());


        /**
         * 查询所有根评论对应的子评论集合，并且赋值给对应的属性
         */
        for (CommentVo commentVo : commentVoList) {
            //查询对应的子评论
            List<CommentVo> children = getChildren(commentVo.getId());
            //赋值
            commentVo.setChildren(children);
        }

        return ResponseResult.okResult(new PageVo(commentVoList, commentPage.getTotal()));
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        //评论内容不能为空
        if (!StringUtils.hasText(comment.getContent())) {
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    /**
     * 根据根评论的id查询所对应的子评论集合
     *
     * @param id
     * @return
     */
    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comment::getRootId, id);
        lambdaQueryWrapper.orderByAsc(Comment::getCreateTime);
        List<Comment> comments = list(lambdaQueryWrapper);
        List<CommentVo> comentVos = toComentVoList(comments);
        return comentVos;
    }

    private List<CommentVo> toComentVoList(List<Comment> list) {
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历vo集合
        for (CommentVo commentVo : commentVos) {
            //通过createBy查询userName
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUserName(nickName);

            //通过toCommentUserId查询toCommentUserName
            //如果toCommentUserId不为-1才进行查询
            if (commentVo.getToCommentUserId() != -1) {
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return commentVos;
    }
}
