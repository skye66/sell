package com.imooc.handler;

import com.imooc.utils.ResultVoUtil;
import com.imooc.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 全局异常处理
 * @Author Skye
 * @Date 2018/11/22 16:52
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * @Author Skye
     * @Description 处理全局 异常 404 、500等错误
     * @Date 2018/11/22 16:54
     * @Param [request, e]
     * @Return com.imooc.vo.ResultVo
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo handlerException(HttpServletRequest request, Exception e){

        log.warn("【用户请求】url地址错误,{}",e.getMessage());
        if (e instanceof NoHandlerFoundException) {
            log.error("【请求出错】{}",e);
            return ResultVoUtil.error(404, request.getRequestURI());
        }else {
            log.error("【请求出错】{}",e);
            return ResultVoUtil.error(500, request.getRequestURI());
        }
    }
}
