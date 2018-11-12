package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    /*买家微信ID*/
    private String buyerOpenid;

    private BigDecimal orderAmount;

    /*订单状态，默认为0新下单*/
    private Integer orderStatus;

    /*支付状态，默认为0未支付*/
    private Integer payStatus;

    /*orderDetail列表*/
    List<OrderDetail> orderDetailList;

}
