package cn.nancode.zm.core;

import cn.nancode.zm.VO.Result;
import cn.nancode.zm.VO.ResultUtil;
import cn.nancode.zm.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nan
 * 2018/6/17
 */
@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public Result RestErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        return ResultUtil.error(ResultEnum.SERVER_ERROR.getCode(), e.getMessage());
    }
}
