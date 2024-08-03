package com.xxuan.controller;

import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.dto.AddTagDto;
import com.xxuan.domain.dto.EditTagDto;
import com.xxuan.domain.dto.TagListDto;
import com.xxuan.domain.entity.Tag;
import com.xxuan.domain.vo.PageVo;
import com.xxuan.domain.vo.TagVo;
import com.xxuan.service.TagService;
import com.xxuan.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: TagController
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-04-01 10:01
 * @Version: V1.0
 */

@RestController
@RequestMapping("content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    //分页查询标签
    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }

    //添加标签
    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable(name = "id") List<Long> ids) {
        tagService.removeByIds(ids);
        return ResponseResult.okResult();
    }


    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable(name = "id") Long id) {
        return ResponseResult.okResult(tagService.getById(id));
    }

    @PutMapping
    public ResponseResult edit(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto,Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}
