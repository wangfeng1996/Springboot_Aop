package com.wang.cacah_demo.service.impl;

import com.wang.cacah_demo.aop.CacheAnnotation;
import com.wang.cacah_demo.dao.UserDao;
import com.wang.cacah_demo.pojo.User;
import com.wang.cacah_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 12:55 下午
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    @CacheAnnotation
    public Map<String, Object> userAdd(User user) {
        Optional<User> optional = Optional.ofNullable(user);
        if (!optional.isPresent()) {
            try {
                throw new Exception("用户信息有误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        try {
            userDao.userAdd(user);
            map.put("message", "添加成功");
        } catch (Exception e) {
            map.put("message", "添加失败");
        }
        return map;
    }
}
