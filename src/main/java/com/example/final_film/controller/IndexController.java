package com.example.final_film.controller;

import com.example.final_film.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/index/login/{name}/{password}")
    @ResponseBody
    public String dologin(@PathVariable("name") String name,@PathVariable("password") String password) {
        String ticket = indexService.login(name,password);
        return ticket;
    }

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
