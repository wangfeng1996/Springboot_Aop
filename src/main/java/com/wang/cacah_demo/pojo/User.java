package com.wang.cacah_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 12:43 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
