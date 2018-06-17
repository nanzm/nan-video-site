package cn.nancode.zm.enums;

public enum ResultEnum {

    SUCCESS(0, "成功"),

    UNKNOWN(1, "未知错误"),
    NOTFOUND(2, "404未找到"),
    UN_AVAILABLE(3, "服务暂不可用"),
    NO_PERMISSION(4, "无权限访问"),
    UN_LOGIN(5, "未登录"),
    ARGUMENT(6, "参数错误"),
    NODATA(7, "无数据"),
    SERVER_ERROR(500, "服务器错误"),

    PRIMARY_SCHOOL(99, "你可能再上小学"),
    MIDDLE_SCHOOL(100, "你可能再上中学"),
    HEIGH_SCHOOL(101, "你上天了"),;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
