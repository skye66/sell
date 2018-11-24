package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/18 11:27
 * @Version 1.0
 **/
@Data
@Entity
@DynamicUpdate
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
    private Date createTime;
    private Date updateTime;
}
