package com.example.final_film.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "rank")
public class Rank {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private int temperature;
    private int week;
    private int month;
    private int favor;
}
