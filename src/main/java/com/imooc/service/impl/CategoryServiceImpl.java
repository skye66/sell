package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.enmus.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductCategoryRepository;
import com.imooc.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategory category = repository.findByCategoryType(productCategory.getCategoryType());
        if (category != null){
            log.info("【增加/更新类目】类目类型已存在，categoryType={}",category.getCategoryType());
            throw new SellException(ResultEnum.PRODUCT_CATEGORY_EXIST);
        }
        return repository.save(productCategory);
    }
}
