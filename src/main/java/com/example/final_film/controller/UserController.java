package com.example.final_film.controller;

import com.example.final_film.entity.User;
import com.example.final_film.param.UserParam;
import com.example.final_film.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    /**
     * 业务逻辑：login
     * @return 返回login页
     */
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 业务逻辑：登陆
     * @return success
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserParam userParam, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        String username = userParam.getUsername();
        String password = userParam.getPassword();

        if(username == null || password == null) {
            response.put("code", 400);
            response.put("message", "用户名或密码为空");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        String ticket = userService.login(username, password);
        if(ticket == null || ticket.equals("")) {
            response.put("code", 400);
            response.put("message", "用户名或密码错误");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("ticket", ticket);
        response.put("code", 200);
        response.put("message", "登陆成功");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 业务逻辑：register
     * @return 返回register页
     */
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * 业务逻辑：注册用户
     * @return success
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody UserParam userParam) {
        Map<String, Object> response = new HashMap<>();
        String username = userParam.getUsername();
        String password = userParam.getPassword();

        if(username == null || password == null) {
            response.put("code", 400);
            response.put("message", "用户名或密码为空");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if(userService.queryByName(username) != null) {
            response.put("code", 400);
            response.put("message", "用户名已存在");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        userService.register(username, password);

        response.put("code", 200);
        response.put("message", "注册成功");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /**
     * 业务逻辑：profile
     * @return 返回profile页
     */
    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        String ticket = (String) session.getAttribute("ticket");
        if(ticket == null) {
            // 同定向到login

            return "redirect:/login";
        }
        // service获取用户信息
        User user = userService.queryByTicket(ticket);
        model.addAttribute("user", user);
        if(user.isMember()){
            model.addAttribute("member", "VIP");
        }else{
            model.addAttribute("member", "普通用户");
        }



        return "profile";
    }

    /**
     * 业务逻辑：update
     * 升级为会员
     */
    @GetMapping("/update")
    public String update(Model model, HttpSession session) {

        String ticket = (String) session.getAttribute("ticket");
        if(ticket == null) {
            return "redirect:/login";
        }
        // service获取用户信息
        User user = userService.queryByTicket(ticket);
        if(user.isMember()){
            return "redirect:/profile";
        }

        userService.updateUser(user);

        return "redirect:/profile";
    }


    /**
     * 业务逻辑：logout
     * @return 返回index页
     */
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        String ticket = (String) session.getAttribute("ticket");
        if(ticket == null) {
            return "redirect:/login";
        }
        userService.logout(ticket);
        session.removeAttribute("ticket");
        return "redirect:/index";
    }
}
