package com.example.final_film.controller;

import com.example.final_film.entity.Film;
import com.example.final_film.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RankController {
    @Autowired
    private RankService rankService;

    //按热播排行
    @GetMapping("/rank/ByTemperature")
    public String rankByTemperature(Model model) {
        List<Film> films = rankService.rankByTemperature();
        model.addAttribute("films",films);
        model.addAttribute("rank_type","热度");
        return "index";
    }

    //本周排行
    @GetMapping("/rank/ByWeek")
    public String rankByWeek(Model model) {
        List<Film> films = rankService.rankByWeek();
        model.addAttribute("films",films);
        model.addAttribute("rank_type","周热度");
        return "index";
    }

    //本月排行
    @GetMapping("/rank/ByMonth")
    public String rankByMonth(Model model) {
        List<Film> films = rankService.rankByMonth();
        model.addAttribute("films",films);
        model.addAttribute("rank_type","月热度");
        return "index";
    }

    //按好评排行
    @GetMapping("/rank/ByFavor")
    public String rankByFavor(Model model) {
        List<Film> films = rankService.rankByFavor();
        model.addAttribute("films",films);
        model.addAttribute("rank_type","好评数");
        return "index";
    }
}
