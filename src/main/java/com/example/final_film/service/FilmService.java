package com.example.final_film.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.final_film.entity.Film;
import com.example.final_film.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService extends ServiceImpl<FilmMapper, Film> {
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public Film findFilmById(Integer id) {
        return filmMapper.selectById(id);
    }

    /**
     * 查询所有电影的信息并将这部分电影信息缓存在redis中
     * @return 返回一个包含所有电影的List对象
     */
    public List<Film> findAll() {
        List<Film> films = filmMapper.selectList(null);
        redisTemplate.opsForValue().set("films",films);
        return films;
    }

    /**
     * 根据演员名查询电影信息
     * @param actor 演员名
     * @return 返回一个含指定演员名电影的List对象
     */
    public List<Film> findFilmByActor(String actor) {
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("actor",actor);
        return filmMapper.selectList(queryWrapper);
    }

    /**
     * 根据地区查询电影信息
     * @param region 地区名
     * @return 返回一个含指定地区电影的List对象
     */
    public List<Film> findFilmByRegion(String region){
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("region",region);
        return filmMapper.selectList(queryWrapper);
    }

    /**
     * 根据电影类型查询电影信息
     * @param type 电影类型
     * @return 返回一个含指定类型电影的List对象
     */
    public List<Film> findFilmByType(String type){
        QueryWrapper<Film> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("type",type);
        return filmMapper.selectList(queryWrapper);
    }

    /**
     * 根据电影基因查询电影信息
     * @param gene 电影基因
     * @return 返回一个含指定电影基因的List对象
     */
    public List<Film> findFilmByGene(String gene){
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gene",gene);
        return filmMapper.selectList(queryWrapper);
    }
}
