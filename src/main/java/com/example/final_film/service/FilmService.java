package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.Film;
import com.example.final_film.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService extends ServiceImpl<FilmMapper, Film> {
    @Autowired
    private FilmMapper filmMapper;

    public List<Film> findAll() {
        return filmMapper.selectList(null);
    }

    public List<Film> findFilmByActor(String actor) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("actor",actor);
        return filmMapper.selectList(queryWrapper);
    }

    public List<Film> findFilmByRegion(String region){
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("region",region);
        return filmMapper.selectList(queryWrapper);
    }

    public List<Film> findFilmByType(String type){
        QueryWrapper<Film> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("type",type);
        return filmMapper.selectList(queryWrapper);
    }

    public List<Film> findFilmByGene(String gene){
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gene",gene);
        return filmMapper.selectList(queryWrapper);
    }
}
