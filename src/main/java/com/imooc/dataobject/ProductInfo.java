package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    /*产品名字*/
    private String productName;
    /*产品价格*/
    private BigDecimal productPrice;
    /*产品库存*/
    private Integer productStock;
    /*产品描述*/
    private String productDescription;
    /*小图*/
    private String productIcon;
    /* 状态，0正常，1下架*/
    private Integer productStatus;
    /*类目编号*/
    private Integer categoryType;
}
