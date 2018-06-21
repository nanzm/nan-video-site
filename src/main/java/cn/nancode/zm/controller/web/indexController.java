package cn.nancode.zm.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nan
 * 2018/6/16
 */

@Controller
public class indexController {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    @GetMapping("/")
    public String index() {

        logger.error("首页错误哦 哦哦哦哦哦哦哦哦哦哦");

        return "index";
    }
}
