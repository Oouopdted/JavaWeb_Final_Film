package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.User;
import com.example.final_film.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 根据redis缓存中的ticket更新指定用户为会员用户
     * @param ticket 指定ticket
     * @return 将更新后的用户信息作为user对象返回
     */
    public User updateUser(String ticket) {
        User user = getUserByTicket(ticket);
        user.setMember(true);
        return user;
    }

    /**
     * 传入ticket查询相关用户的信息
     * @param ticket redis中ticket值
     * @return 相关用户对象
     */
    public User getUserByTicket(String ticket) {
        String name = (String) redisTemplate.opsForValue().get(ticket);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

}
