package com.dingjiajia.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 18:07:17
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

