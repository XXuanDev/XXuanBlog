package com.xxuan.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxuan.domain.entity.ArticleTag;
import com.xxuan.mapper.ArticleTagMapper;
import com.xxuan.service.ArticleTagService;
import org.springframework.stereotype.Service;
/**
 * 文章标签关联表(ArticleTag)表服务实现类
 *
 * @author makejava
 * @since 2024-04-09 10:08:30
 */
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {
}
