package com.example.final_film.controller;

import com.example.final_film.service.FilmService;
import com.example.final_film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@Controller
public class PlayController {

    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    private Charset charset = Charset.forName("UTF-8");

    @GetMapping("/play")
    public String play(@RequestParam("id") Integer filmId, HttpSession session){
        Object tic_obj = session.getAttribute("ticket");

        if(tic_obj == null || tic_obj.toString().equals("") ) {
            return "login";
        }
        if(!userService.queryByTicket(tic_obj.toString()).isMember()){
            return "redirect:/profile";
        }
        String movieName = filmService.findFilmById(filmId).getName();
        if(movieName == null || movieName.equals("")) {
            return "index";
        }
        // 将movieName转成url格式
        movieName = URLEncoder.encode( movieName, charset);

        return "redirect:https://search.bilibili.com/all?keyword="+movieName;
    }

}
