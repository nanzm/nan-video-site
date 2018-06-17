package cn.nancode.zm.controller.web;

import cn.nancode.zm.dataobject.User;
import cn.nancode.zm.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by nan
 * 2018/6/14
 */
@Controller
public class UserWebController {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
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
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
        } catch (Exception e) {
            map.addAttribute("error", "邮箱已被注册");
            return "/register";
        }

        map.addAttribute("msg", "添加成功！请登录");
        return "/login";
    }

}
