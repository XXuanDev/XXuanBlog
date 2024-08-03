package com.xxuan.domain.vo;

import com.xxuan.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: RoutersVo
 * @Description: TODO
 * @Author: XXuan
 * @date: 2024-04-02 22:50
 * @Version: V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutersVo {
    private List<Menu> menus;

}
