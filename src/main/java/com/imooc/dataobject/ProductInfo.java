package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enmus.PayStatusEnum;
import com.imooc.enmus.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 2765953656149821812L;
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /*类目编号*/
    private Integer categoryType;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(this.productStatus, ProductStatusEnum.class);
    }
}
