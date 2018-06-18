package cn.nancode.zm.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * http 请求返回对象
 */
@Data
@ApiModel(description = "返回结果")
public class Result<T> {

    @ApiModelProperty("请求状态")
    private Integer code;

    @ApiModelProperty("描述性原因")
    private String msg;

    @ApiModelProperty("业务数据")
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
