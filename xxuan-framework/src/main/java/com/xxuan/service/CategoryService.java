package com.xxuan.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.entity.Category;
import com.xxuan.domain.vo.CategoryVo;
import com.xxuan.domain.vo.PageVo;

import java.util.List;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2024-03-21 09:19:31
 */

public interface CategoryService extends IService<Category> {


    ResponseResult getCategoryList();

    List<CategoryVo> listAllCategory();

    PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize);
}
