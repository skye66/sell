package com.imooc.controller;

import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enmus.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVoUtil;
import com.imooc.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("create")
    public ResultVo<Map<String, String>> create( @Valid  OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVoUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                            @RequestParam(value = "num", defaultValue = "0") int num,
                                            @RequestParam(value = "size", defaultValue = "10") int size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(num,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return  ResultVoUtil.success(orderDTOPage.getContent());

    }


    //订单详情

    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);
        return ResultVoUtil.success(orderDTO);

    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        //todo 不安全

        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();

    }
}
