package com.wang.cacah_demo.dao;

import com.wang.cacah_demo.pojo.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 12:46 下午
 */
@Mapper
@Repository
public interface UserDao{
    /**
     * 添加用户
     * @param user
     */
    @InsertProvider(type = UserProvider.class,method = "userAddSql")
    void userAdd(User user);
}
