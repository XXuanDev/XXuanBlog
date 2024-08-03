package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CategoryController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-21 10:59
 * @Version: V1.0
 */

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getCategoryList")
    public ResponseResult getCategoryList() {
        return categoryService.getCategoryList();

    }
}
