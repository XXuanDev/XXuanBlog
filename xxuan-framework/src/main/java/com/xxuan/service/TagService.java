package com.xxuan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxuan.domain.ResponseResult;
import com.xxuan.domain.dto.TagListDto;
import com.xxuan.domain.entity.Tag;
import com.xxuan.domain.vo.PageVo;
import com.xxuan.domain.vo.TagVo;

import java.util.List;

/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 09:52:00
 */

public interface TagService extends IService<Tag> {
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);
    List<TagVo> listAllTag();
}
