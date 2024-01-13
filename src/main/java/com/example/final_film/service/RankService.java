package com.example.final_film.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.Film;
import com.example.final_film.entity.Rank;
import com.example.final_film.mapper.RankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService extends ServiceImpl<RankMapper, Rank> {
    @Autowired
    private RankMapper rankMapper;

    /**
     * 业务逻辑：热度排行
     * @return 注意返回的是Film的List表
     */
//    public List<Film> rankByTemperature() {
//    }

    /**
     * 业务逻辑：周排行
     * @return 注意返回的是Film的List表
     */
//    public List<Film> rankByWeek() {
//    }

    /**
     * 业务逻辑：月排行
     * @return 注意返回的是Film的List表
     */
//    public List<Film> rankByMonth() {
//    }

    /**
     * 业务逻辑：好评排行
     * @return 注意返回的是Film的List表
     */
//    public List<Film> rankByFavor() {
//    }
}
