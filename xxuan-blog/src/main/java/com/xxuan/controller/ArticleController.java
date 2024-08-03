package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.Article;
import com.xxuan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ArticleController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-20 16:21
 * @Version: V1.0
 */


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> list() {
//        return articleService.list();
//    }

    //查询热门文章列表
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        //查询热门文章，封装成ResponseResult返回
        ResponseResult responseResult = articleService.hotArticleList();
        return responseResult;
    }

    //查询文章列表
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    //查询文章详情
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }

    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }

}
