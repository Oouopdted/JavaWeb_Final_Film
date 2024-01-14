package com.example.final_film.controller;

import com.example.final_film.entity.User;
import com.example.final_film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService = new UserService();

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
