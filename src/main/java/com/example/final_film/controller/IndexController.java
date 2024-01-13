package com.example.final_film.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 业务逻辑：index
     * @return 返回index页
     */
    @GetMapping({"/","/index"})
    public String index(Model model) {
        return "index";
    }




    /**
     * 业务逻辑：profile
     * @return 返回profile页
     */
    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        if(session.getAttribute("user") == null) {
            // 同定向到login

            return "redirect:/login";
        }
        return "profile";
    }



}
