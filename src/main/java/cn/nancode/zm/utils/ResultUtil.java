package cn.nancode.zm.utils;

import cn.nancode.zm.enums.ResultEnum;

/**
 *
 */
public class ResultUtil {

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }


    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg("发生了错误");
        result.setData(data);
        return result;
    }
}
