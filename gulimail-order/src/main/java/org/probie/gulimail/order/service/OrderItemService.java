package org.probie.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.probie.gulimail.common.utils.PageUtils;
import org.probie.gulimail.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author wangfei
 * @email 731746237@qq.com
 * @date 2020-06-16 16:09:51
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

