package com.imooc.service;


import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    /*查找在架商品列表*/
    List<ProductInfo> findUpAll();

    /*管理员查询所有的商品*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //todo 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //todo 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
