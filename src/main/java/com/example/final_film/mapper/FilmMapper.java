package com.example.final_film.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.final_film.entity.Film;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FilmMapper extends BaseMapper<Film> {
}
