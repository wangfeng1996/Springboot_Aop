package com.wang.cacah_demo.service;

import com.wang.cacah_demo.pojo.User;

import java.util.Map;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 12:54 下午
 */
public interface UserService {
    /**
     * 添加用户信息的接口
     * @param user
     * @return
     */
    Map<String, Object> userAdd(User user);
}
