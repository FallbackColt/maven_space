package com.practice.finance.dao.impl;

import com.practice.finance.dao.UserDao;
import com.practice.finance.pojo.User;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/2/22 16:06
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `username`, `password`, `name`, `department`," +
                " `superior`, `account` from user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `username`, `name`, `department`, `superior`, `account`" +
                " from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select `id`, `username`, `name`, `department`, `superior`, `account` from user";
        List<User> users = queryForList(User.class, sql);
        System.out.println(users);
        return users;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`, `password`, `name`, `department`, `superior`, `account`)" +
                " value(?, ?, ?, ?, ?, ?)";
        return update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getDepartment(),
                user.getSuperior(),
                user.getAccount()
        );
    }

    @Override
    public boolean updateUserPassword(String username, String password, String rePassword) {
        String sql = "update user set `password`=? where `username`=? and `password`=?";
        return (update(sql, rePassword, username, password)==1);
    }

    @Override
    public boolean updateUserInfoByID(int ID, String username, String name, int department, String superior, String account) {
        String sql = "update user set `username`=?, `name`=?, `department`=?, `superior`=?, `account`=? where `id`=?";
        return (update(sql, username, name, department, superior, account, ID)==1);
    }

    @Override
    public List<User> queryUsersByUsername(String username) {
        String sql = "select `username`, `name`, `department`, `superior`, `account` from user where username like ?";
        return queryForList(User.class, sql, "%"+username+"%");
    }

    @Override
    public boolean deleteUserByIdAndUsername(int ID, String username) {
        String sql = "delete from user where `id`=? and `username`=?";
        return update(sql, ID, username)==1;
    }


}
