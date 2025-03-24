package com.dingjiajia.mall.order.dao;

import com.dingjiajia.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 18:07:17
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
