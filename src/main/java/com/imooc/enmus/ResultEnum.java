package com.imooc.enmus;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存错误"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单商品详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20, "微信公众账号错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信支付异步通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(22,"订单成功取消"),
    ORDER_FINISHED_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24,"产品上下架状态错误"),
    PRODUCT_CATEGORY_EXIST(25,"类目已存在"),
    LOGIN_FAIL(26,"登陆错误，登陆信息不正确"),
    LOGOUT_SUCCESS(27, "登出成功"),
    REQUEST_URL_PARAM_ERROR(28, "请求参数错误"),


    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
