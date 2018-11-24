package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enmus.ResultEnum;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Description 卖家端的后台控制
 * @Author Skye
 * @Date 2018/11/15 15:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * @Author Skye
     * @Description 查询订单列表
     * @Date 2018/11/15 21:05
     * @Param [page, size, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request =  PageRequest.of(page-1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
//        orderDTOPage.getContent().get(2).getOrderStatusEnum().getMsg();
        return new ModelAndView("/order/list", map);
    }
    /**
     * @Author Skye
     * @Description 
     * @Date 2018/11/15 22:29
     * @Param [orderId, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                              Map<String, Object> map){

        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (Exception e){
            log.info("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
   /**
    * @Author Skye
    * @Description
    * @Date 2018/11/15 21:07
    * @Param [orderId, map]
    * @Return org.springframework.web.servlet.ModelAndView
    * @
    **/
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        OrderDTO orderDTO;
        try{
            orderDTO = orderService.findOne(orderId);
        }catch (Exception e){
            log.info("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("/order/detail",map);
    }
    /**
     * @Author Skye
     * @Description 完结订单并跳转freemark视图
     * @Date 2018/11/15 22:22
     * @Param [orderId, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/finished")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
                                 Map<String, Object> map){
        OrderDTO orderDTO;
        try{
            orderDTO = orderService.findOne(orderId);
            orderService.finished(orderDTO);
        }catch (Exception e){
            log.info("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISHED_SUCCESS.getMessage());
        map.put("orderDTO", orderDTO);
        return new ModelAndView("/order/detail",map);
    }
}
