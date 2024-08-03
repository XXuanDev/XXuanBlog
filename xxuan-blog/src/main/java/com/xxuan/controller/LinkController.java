package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.service.LinkService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LinkController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-03-25 9:00
 * @Version: V1.0
 */

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
