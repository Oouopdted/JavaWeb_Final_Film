package com.example.final_film.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "film_rank")
public class Rank implements Serializable {
    private static final long serialVersionUID = 2l;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private int temperature;
    private int week;
    private int month;
    private int favor;
}
