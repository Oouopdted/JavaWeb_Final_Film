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

    /**
     * 传入用户名和密码进行登陆，如果用户登陆成功则生成随机ticket，并作为set<ticket,name>集合形式存入redis缓存中,缓存中的ticket30个小时后消亡。
     * @param name 用户名
     * @param password 用户密码
     * @return 如果用户存在返回ticket，不存在则返回空字符串。
     */
    public String login(String name,String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        User user = userMapper.selectOne(queryWrapper);
        if (user==null) {
            return "";
        } else if (user.getPassword().equals(password)) {
            String ticket = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(ticket,user.getName(),Duration.ofMinutes(30));
            return ticket;
        }else {
            return "";
        }
    }

    /**
     * 根据redis缓存中的ticket值查询对应用户信息并返回,查询结果会缓存在redis中
     * @param ticket redis缓存中的ticket值
     * @return 返回相应用户
     */
    public User queryByTicket(String ticket) {
        String name = (String) redisTemplate.opsForValue().get(ticket);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 根据ticket删除redis中用户的缓存数据，但数据库中的数据未被删除
     * @param ticket 用户相应的ticket
     */
    public void logout(String ticket) {
        redisTemplate.delete(ticket);
    }

    /**
     * 传入用户名和密码进行注册，注册后用户默认为非会员用户，此时用户的信息未存进redis缓存中，需注册后需再次登陆
     * @param name 用户名
     * @param password 密码
    */
    public void register(String name,String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setMember(false);
        userMapper.insert(user);
    }
}
