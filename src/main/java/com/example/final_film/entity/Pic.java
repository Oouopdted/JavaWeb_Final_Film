package com.example.final_film.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "pic")
public class Pic {
    private Integer id;
    private Integer file_id;
    private String url;
}
