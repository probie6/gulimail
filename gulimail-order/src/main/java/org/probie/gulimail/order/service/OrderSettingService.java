package org.probie.gulimail.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.probie.gulimail.common.utils.PageUtils;
import org.probie.gulimail.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author wangfei
 * @email 731746237@qq.com
 * @date 2020-06-16 16:09:51
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

