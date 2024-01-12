package com.example.final_film.controller;

import com.example.final_film.entity.Film;
import com.example.final_film.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RankController {
    @Autowired
    private RankService rankService;

    //按热播排行
    @RequestMapping("/rank/rankByTemperature")
    @ResponseBody
    public List<Film> rankByTemperature() {
        return rankService.rankByTemperature();
    }

    //本周排行
    @RequestMapping("/rank/rankByWeek")
    @ResponseBody
    public List<Film> rankByWeek() {
        return rankService.rankByWeek();
    }

    //本月排行
    @RequestMapping("/rank/rankByMonth")
    @ResponseBody
    public List<Film> rankByMonth() {
        return rankService.rankByMonth();
    }

    //按好评排行
    @RequestMapping("/rank/rankByFavor")
    @ResponseBody
    public List<Film> rankByFavor() {
        return rankService.rankByFavor();
    }
}
