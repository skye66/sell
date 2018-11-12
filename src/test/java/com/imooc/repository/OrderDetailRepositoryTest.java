package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("1222");
        orderDetail.setDetailId("1222233");
        orderDetail.setProductQuantity(21);
        orderDetail.setProductPrice(new BigDecimal(2.4));
        orderDetail.setProductName("good");
        orderDetail.setProductId("2222");
        orderDetail.setProductIcon("http://xxx.baidu.com");
        OrderDetail result = repository.save(orderDetail);

        Assert.assertNotEquals(null, result);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1222");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}