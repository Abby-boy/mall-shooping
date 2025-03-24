package com.dingjiajia.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 17:48:43
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

