package com.imooc.utils;

import com.imooc.enmus.ResultEnum;
import com.imooc.vo.ResultVo;

public class ResultVoUtil {


    public static <T>ResultVo success(T t){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(t);
        return resultVo;
    }
    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(int code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setCode(code);
        return resultVo;
    }
    public static <T>ResultVo error(T t){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.PARAM_ERROR.getCode());
        resultVo.setMsg(ResultEnum.PARAM_ERROR.getMessage());
        resultVo.setData(t);
        return resultVo;
    }

}
