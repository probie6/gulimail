package org.probie.gulimail.order.dao;

import org.probie.gulimail.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wangfei
 * @email 731746237@qq.com
 * @date 2020-06-16 16:09:51
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
