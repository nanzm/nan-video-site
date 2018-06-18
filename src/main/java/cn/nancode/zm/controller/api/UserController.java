package cn.nancode.zm.controller.api;


import cn.nancode.zm.utils.Result;
import cn.nancode.zm.utils.ResultUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

//    @GetMapping("/me")
//    public Object getCurrentUser() {
//        return SecurityContextHolder.getContext().getAuthentication();
//    }

//    @GetMapping("/me")
//    public Result getCurrentUser(Authentication authentication) {
//        return ResultUtil.success(authentication);
//    }

    @GetMapping("/me")
    public Result getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return ResultUtil.success(user);
    }

}
