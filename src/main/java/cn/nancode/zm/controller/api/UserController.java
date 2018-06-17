package cn.nancode.zm.controller.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: nan-computer
 * Date: 2018/6/3 19:02
 * Description:
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @GetMapping
    public String index() {
        return "index";
    }
}
