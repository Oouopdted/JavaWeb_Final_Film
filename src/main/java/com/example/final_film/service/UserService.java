package com.example.final_film.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.User;
import com.example.final_film.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    @Autowired
    private UserMapper userMapper;
}
