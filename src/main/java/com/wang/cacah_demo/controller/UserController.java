package com.wang.cacah_demo.controller;

import com.wang.cacah_demo.pojo.User;
import com.wang.cacah_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 1:03 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户的接口
     * http://localhost:8088/user
     * 数据类型
     * {
     *     "id":1236,
     *     "name":"qwer",
     *     "age":12
     * }
     * @param user
     * @return
     */
    @PostMapping
    public Map userAdd(@RequestBody  User user) {
        System.out.println(user);
        Map<String, Object> map = userService.userAdd(user);
        return map;
    }
}
