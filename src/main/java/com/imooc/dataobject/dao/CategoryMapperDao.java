package com.imooc.dataobject.dao;
import com.imooc.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/22 22:22
 * @Version 1.0
 **/
public class CategoryMapperDao{

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public void insetMap(Map<String, Object> map){
        productCategoryMapper.insertByMap(map);
    }
}
