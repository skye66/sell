package com.imooc.repository;

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


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory =repository.findById(1).get();
        System.out.println(productCategory);

    }
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("我最爱的",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<ProductCategory> productCategoryList=repository.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

}