package com.xxuan.runner;

import com.xxuan.domain.entity.Article;
import com.xxuan.mapper.ArticleMapper;
import com.xxuan.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName: ViewCountRunner
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-30 9:15
 * @Version: V1.0
 */

@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void run(String... args) throws Exception {
        //查询博客信息 id viewCount
        List<Article> articles = articleMapper.selectList(null);
        Map<String, Integer> viewCountMap = articles.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));
        //存到redis中
        redisCache.setCacheMap("article:viewCount",viewCountMap);
    }
}
