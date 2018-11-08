package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory category = categoryService.save(new ProductCategory("男生专享", 100));
        Assert.assertNotNull(category);
    }
}