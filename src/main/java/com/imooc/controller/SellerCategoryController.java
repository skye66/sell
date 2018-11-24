package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/17 11:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * @Author Skye
     * @Description 查询类目列表
     * @Date 2018/11/17 14:32
     * @Param [map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/list")
    public ModelAndView list(Map<String, Object> map){

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }
    /**
     * @Author Skye
     * @Description 类目的增加或者修改
     * @Date 2018/11/17 14:47
     * @Param [categoryId, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(required = false,value = "categoryId") Integer categoryId,
                              Map<String, Object> map){

        if (categoryId  != null){
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * @Author Skye
     * @Description 保存或者更新类目
     * @Date 2018/11/17 15:08
     * @Param [categoryForm, bindingResult, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if (bindingResult.hasErrors()){

            map.put("url", "/sell/seller/category/index");
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error", map);
        }
        ProductCategory category = new ProductCategory();
        try {
            if (categoryForm.getCategoryId() != null){
               category = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, category);
            categoryService.save(category);
        }catch (SellException e){
            String url = "/sell/seller/category/index?categoryId="+categoryForm.getCategoryId();
            map.put("url", url);
            map.put("category", category);
            map.put("msg", e.getMessage());
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView ("common/success", map);

    }

}
