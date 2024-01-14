package com.example.final_film.controller;

import com.example.final_film.entity.Film;
import com.example.final_film.service.FilmService;
import com.example.final_film.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private FilmService filmService;
    /**
     * 业务逻辑：index
     * @return 返回index页
     */
    @GetMapping({"/","/index"})
    public String index(Model model) {
        List<Film> films = filmService.findAll();
        model.addAttribute("films",films);



        return "index";
    }

    /**
     * 业务逻辑：根据演员查询电影
     * @return 返回index页
     */
    @GetMapping("/search")
    public String indexByActor(@RequestParam("actor") String actor, Model model) {
        List<Film> films = filmService.findFilmByActor(actor);
        model.addAttribute("films",films);
        return "index";
    }




}
