package com.practice.finance.dao.impl;

import com.practice.finance.dao.UserDao;
import com.practice.finance.pojo.User;

/**
 * @author: 18040
 * @date: 2023/2/22 16:06
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `email` from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`, `username`, `email` from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) value(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getPosition());
    }

}
