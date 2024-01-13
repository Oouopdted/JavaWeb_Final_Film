package com.example.final_film.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.User;
import com.example.final_film.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据前端中的id查询指定用户的信息
     * @param id 用户id
     * @return 指定用户信息，并返回user对象
     */
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    /**
     * 更新指定用户为会员用户
     * @param user 需要更新的用户
     * @return 将更新后的用户信息作为user对象返回
     */
    public User updateUser(User user) {
        User update_user = userMapper.selectById(user.getId());
        update_user.setMember(true);
        userMapper.updateById(update_user);
        return userMapper.selectById(update_user.getId());
    }
}
