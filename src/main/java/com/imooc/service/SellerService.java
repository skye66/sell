package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/18 22:08
 * @Version 1.0
 **/
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
