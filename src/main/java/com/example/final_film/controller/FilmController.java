package com.example.final_film.controller;

import com.example.final_film.entity.Film;
import com.example.final_film.service.FilmService;
import com.example.final_film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;
    @RequestMapping("/film/findAllFilm")
    @ResponseBody
    public List<Film> findAllFilm() {
        return filmService.findAll();
    }

    @RequestMapping("/film/findFilmByActor")
    @ResponseBody
    public List<Film> findFilmByActor(String actor) {
        if(!"".equals(actor))
            return filmService.findFilmByActor(actor);
        else return null;
    }

    @RequestMapping("/film/findFilmByRegion")
    @ResponseBody
    public List<Film> findFilmByRegion(String region) {
        if(!"".equals(region))
            return filmService.findFilmByRegion(region);
        else return null;
    }

    @RequestMapping("/film/findFilmByType")
    @ResponseBody
    public List<Film> findFilmByType(String type) {
        if(!"".equals(type))
            return filmService.findFilmByType(type);
        else return null;
    }

    @RequestMapping("/film/findFilmByGene")
    @ResponseBody
    public List<Film> findFilmByGene(String gene) {
        if (!"".equals(gene))
            return filmService.findFilmByGene(gene);
        else return null;
    }



    /**
     * 业务逻辑：detail
     * @return 返回detail页
     */
    @GetMapping("/film/detail/{id}")
    public String detail(Model model , @PathVariable("id") int id, HttpSession httpSession) {
        model.addAttribute("id",id);
        // service查询
        Film film = filmService.findFilmById(id);
        model.addAttribute("film", film);
        Object obj = httpSession.getAttribute("ticket");
        if(obj != null && !obj.toString().equals("")) {
            String ticket = obj.toString();
            String VIP = userService.queryByTicket(ticket).isMember()? "VIP":"普通用户";
            model.addAttribute("member", VIP);
        }


        return "detail";
    }

    @GetMapping("/film/groupByType")
    public String groupByType(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByType();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","类型");

        return "groupBy";
    }

    @GetMapping("/film/groupByGene")
    public String groupByGene(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByGene();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","Gene");

        return "groupBy";
    }

    @GetMapping("/film/groupByRegion")
    public String groupByRegion(Model model) {
        Map<String, List<Film>> mp_films = filmService.groupByRegion();
        model.addAttribute("mp_films",mp_films);
        model.addAttribute("group_type","地区");

        return "groupBy";
    }

}
