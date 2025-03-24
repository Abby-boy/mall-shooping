package com.dingjiajia.mall.product.dao;

import com.dingjiajia.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 15:01:42
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
