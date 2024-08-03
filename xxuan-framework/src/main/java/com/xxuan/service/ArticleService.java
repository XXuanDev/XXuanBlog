package com.xxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.dto.AddArticleDto;
import com.xxuan.domain.dto.ArticleDto;
import com.xxuan.domain.entity.Article;
import com.xxuan.domain.vo.ArticleVo;
import com.xxuan.domain.vo.PageVo;

/**
 * @ClassName: ArticleService
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-20 16:17
 * @Version: V1.0
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    ResponseResult add(AddArticleDto article);

    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);

    ArticleVo getInfo(Long id);

    void edit(ArticleDto article);
}

