package com.dingjiajia.mall.order.dao;

import com.dingjiajia.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 18:07:17
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
