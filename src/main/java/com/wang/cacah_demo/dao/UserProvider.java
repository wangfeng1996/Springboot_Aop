package com.wang.cacah_demo.dao;

import com.wang.cacah_demo.pojo.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/3 12:48 下午
 */
@Component
public class UserProvider {


    /**
     * 添加用户的动态sql语句
     * @param user
     * @return
     */
    public String userAddSql(User user) {
        String sql = new SQL()
                .INSERT_INTO("mybatis_plus.user")
                .INTO_COLUMNS("id", "name", "age", "create_time", "update_time")
                .INTO_VALUES("#{id}", "#{name}", "#{age}", "#{createTime}", "#{updateTime}")
                .toString();
        return sql;
    }
}
