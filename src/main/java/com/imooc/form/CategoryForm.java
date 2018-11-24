package com.imooc.form;

import lombok.Data;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/17 14:53
 * @Version 1.0
 **/
@Data
public class CategoryForm {
    private Integer categoryId;
    //类目名字
    private String categoryName;
    //类目编号
    private Integer categoryType;
}
