package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.Film;
import com.example.final_film.entity.Rank;
import com.example.final_film.mapper.FilmMapper;
import com.example.final_film.mapper.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class RankService extends ServiceImpl<RankMapper, Rank> {
    @Autowired
    private RankMapper rankMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 热度排行
     * @return 返回按照热度排行的Film列表
     */
    public List<Film> rankByTemperature() {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("temperature");
        List<Rank> ranks=rankMapper.selectList(queryWrapper);
        List<Film> films = new ArrayList<>();
        for (Rank rank:ranks) {
            Film film =  filmMapper.selectById(rank.getId());
            films.add(film);
        }
        redisTemplate.opsForValue().set("temperature",films, Duration.ofMinutes(30));
        return films;
    }

    /**
     * 周排行
     * @return 返回按照周排行的Film列表
     */
    public List<Film> rankByWeek() {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("week");
        List<Rank> ranks=rankMapper.selectList(queryWrapper);
        List<Film> films = new ArrayList<>();
        for (Rank rank:ranks) {
            Film film =  filmMapper.selectById(rank.getId());
            films.add(film);
        }
        redisTemplate.opsForValue().set("week",films,Duration.ofMinutes(30));
        return films;
    }

    /**
     * 月排行
     * @return 返回按照月排行的Film列表
     */
    public List<Film> rankByMonth() {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("month");
        List<Rank> ranks=rankMapper.selectList(queryWrapper);
        List<Film> films = new ArrayList<>();
        for (Rank rank:ranks) {
            Film film =  filmMapper.selectById(rank.getId());
            films.add(film);
        }
        redisTemplate.opsForValue().set("month",films,Duration.ofMinutes(30));
        return films;
    }

    /**
     * 好评排行
     * @return 返回按照好评排行的Film列表
     */
    public List<Film> rankByFavor() {
        QueryWrapper<Rank> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("favor");
        List<Rank> ranks=rankMapper.selectList(queryWrapper);
        List<Film> films = new ArrayList<>();
        for (Rank rank:ranks) {
            Film film =  filmMapper.selectById(rank.getId());
            films.add(film);
        }
        redisTemplate.opsForValue().set("favour",films,Duration.ofMinutes(30));
        return films;
    }
}
