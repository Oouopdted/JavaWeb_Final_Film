package com.example.final_film.controller;

import com.example.final_film.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
