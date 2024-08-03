package com.xxuan.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxuan.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-25 13:13:12
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
