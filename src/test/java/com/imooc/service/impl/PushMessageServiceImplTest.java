package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/21 22:10
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PushMessageServiceImplTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("12345666");
        if (orderDTO != null) {
            pushMessageService.orderStatus(orderDTO);
        }
    }
}