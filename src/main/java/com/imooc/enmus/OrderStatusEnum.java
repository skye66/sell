package com.imooc.enmus;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String msg;

    OrderStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
   /* public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()){
            if (code.equals(orderStatusEnum.getCode())){
                return orderStatusEnum;
            }
        }
        return null;
    }*/
}
