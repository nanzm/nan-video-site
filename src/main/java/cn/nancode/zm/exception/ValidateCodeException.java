package cn.nancode.zm.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by nan
 * 2018/6/18
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
