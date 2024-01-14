package com.example.final_film.controller;

import com.example.final_film.entity.User;
import com.example.final_film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    /**
     * 业务逻辑：login
     * @return 返回login页
     */
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 业务逻辑：register
     * @return 返回register页
     */
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * 业务逻辑：注册用户
     * @return success
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username, @RequestParam String password) {
        // service注册
        return "success";
    }

    /**
     * 调试用方法
     * @param ticket 前端传入ticket
     * @return user的用户信息
     */
    @RequestMapping("/user/{ticket}")
    @ResponseBody
    public User findByTicket(@PathVariable("ticket") String ticket){
        User user = userService.getUserByTicket(ticket);
        return user;
    }
}
