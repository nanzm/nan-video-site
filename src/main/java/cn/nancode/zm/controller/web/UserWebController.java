package cn.nancode.zm.controller.web;

import cn.nancode.zm.dao.User;
import cn.nancode.zm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by nan
 * 2018/6/14
 */
@Controller
public class UserWebController {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/info")
    public String info(@AuthenticationPrincipal UserDetails user, ModelMap map) {
        System.out.println(user);
        map.addAttribute("userInfo", user);
        return "info";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@Validated User user, BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "/register";
        }

        try {
            user.setEncodePassword(user.getPassword());
            userService.saveUser(user);
        } catch (Exception e) {
            map.addAttribute("error", "邮箱已被注册");
            return "/register";
        }

        map.addAttribute("msg", "添加成功！请登录");
        return "/login";
    }

}
