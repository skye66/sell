package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/17 9:50
 * @Version 1.0
 **/
@Data
public class ProductForm {

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
    /*类目编号*/
    private Integer categoryType;
}
