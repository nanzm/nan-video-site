package cn.nancode.zm.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Aspect
//@Component
public class HttpLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpLogAspect.class);

    @Pointcut("execution(public * cn.nancode.zm.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        logger.info("url={}", request.getRequestURL());
//        logger.info("method={}", request.getMethod());
//        logger.info("ip={}", request.getRemoteAddr());
//        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getClass());
//        logger.info("args={}", joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {

    }

    //打印返回对象
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
//        logger.info("response={}", object.toString());
    }

}