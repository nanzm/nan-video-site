package cn.nancode.zm.utils;

import cn.nancode.zm.vo.Result;
import cn.nancode.zm.vo.ResultUtil;
import cn.nancode.zm.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nan
 * 2018/6/17
 */
@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Result RestErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), e.getMessage());
    }
}
