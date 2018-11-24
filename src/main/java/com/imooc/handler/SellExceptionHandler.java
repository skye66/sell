package com.imooc.handler;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.enmus.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.ResultVoUtil;
import com.imooc.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/21 16:30
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;


    /**
     * http://localhost:8080/sell/wechat/qrAuthorize?returnUrl=http://localhost:8080/sell/seller/login
     * @return
     */
    @ExceptionHandler(SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
            return new ModelAndView("redirect:"
                    .concat(projectUrlConfig.getWechatOpenAuthorize())
                    .concat("/sell/wechat/qrAuthorize")
                    .concat("?returnUrl=")
                    .concat(projectUrlConfig.getProjectUrl())
                    .concat("/sell/seller/login"));
    }
    @ExceptionHandler(SellException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVo handlerSellException(SellException e){
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }

}
