package com.dingjiajia.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 18:07:17
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

