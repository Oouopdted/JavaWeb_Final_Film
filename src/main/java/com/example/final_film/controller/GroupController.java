package com.example.final_film.controller;

import com.example.final_film.entity.Film;
import com.example.final_film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

@Controller
public class GroupController {
    @Autowired
    private FilmService filmService;

    /**
     * 业务逻辑：根据type分类电影
     * @return 返回index页
     */
    @GetMapping("/group/ByType")
    public String groupByType(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByType();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","类型");

        return "groupBy";
    }
    /**
     * 业务逻辑：根据Gene分类电影
     * @return 返回index页
     */
    @GetMapping("/group/ByGene")
    public String groupByGene(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByGene();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","Gene");

        return "groupBy";
    }
    /**
     * 业务逻辑：根据Region分类电影
     * @return 返回index页
     */
    @GetMapping("/group/ByRegion")
    public String groupByRegion(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByRegion();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","地区");

        return "groupBy";
    }

}
