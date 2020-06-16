package org.probie.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.probie.gulimail.common.utils.PageUtils;
import org.probie.gulimail.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author wangfei
 * @email 731746237@qq.com
 * @date 2020-06-16 16:09:51
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

