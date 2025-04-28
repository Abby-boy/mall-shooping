package com.dingjiajia.mall.product.dao;

import com.dingjiajia.mall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiajia.mall.product.vo.SkuItemSaleAttrVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * sku销售属性&值
 * 
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 15:01:41
 */
@Mapper
public interface SkuSaleAttrValueDao extends BaseMapper<SkuSaleAttrValueEntity> {

    List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId);
}
