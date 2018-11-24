package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/21 19:52
 * @Version 1.0
 **/
public interface PushMessageService {
    /**
     * 订单消息变更
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
