package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/22 22:43
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap();
        map.put("categoryName", "乐扣乐扣");
        map.put("categoryType", 51);
        int result = categoryMapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }
    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("本科生");
        productCategory.setCategoryType(40);
        int result = categoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }
    @Test
    public void selectByCategoryType(){
        ProductCategory category = categoryMapper.selectByCategoryType(40);
        Assert.assertNotNull(category);
    }
    @Test
    public void selectByCategoryName(){
        List<ProductCategory> categoryList = categoryMapper.selectByCategoryName("乐扣乐扣");
        Assert.assertNotEquals(0, categoryList.size());
    }
    @Test
    public void updateCategoryNameByType(){
        int row = categoryMapper.updateCategoryNameByType("家豪", 40);
        Assert.assertNotEquals(0, row);
    }
    @Test
    public void updateCategoryNameByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(40);
        productCategory.setCategoryName("镇豪");
        int row = categoryMapper.updateCategoryNameByObject(productCategory);
        Assert.assertNotEquals(0,row);
    }
    @Test
    public void deleteByCategoryType(){
        int row = categoryMapper.deleteByCategoryType(40);
        Assert.assertNotEquals(0,row);
    }
    @Test
    public void findByCategoryName(){
        List <ProductCategory> productCategoryList = categoryMapper.findByCategoryName("乐扣乐扣");
        Assert.assertNotEquals(0, productCategoryList.size());
    }
}
