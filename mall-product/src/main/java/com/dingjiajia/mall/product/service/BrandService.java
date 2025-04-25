package com.dingjiajia.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.product.entity.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 15:01:42
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);

    List<BrandEntity> getBrandsByIds(List<Long> brandIds);
}

