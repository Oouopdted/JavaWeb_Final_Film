package com.example.final_film.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "film")
public class Film {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String maker;
    private String actor;
    private String type;
    private String region;
    private String gene;
}
