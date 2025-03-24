package com.dingjiajia.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.product.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 15:01:42
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveImages(Long id, List<String> images);
}

