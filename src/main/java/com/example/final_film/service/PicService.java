package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.final_film.entity.Pic;
import com.example.final_film.mapper.PicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {
    @Autowired
    PicMapper picMapper;

    List<Pic> findByFilmId(Integer filmId){

        QueryWrapper<Pic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("film_id",filmId);
        return picMapper.selectList(queryWrapper);
    }

}
