package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.final_film.entity.User;
import com.example.final_film.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.UUID;

@Service
public class IndexService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;


}
