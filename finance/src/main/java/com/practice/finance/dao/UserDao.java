package com.practice.finance.dao;


import com.practice.finance.pojo.User;

/**
 * @author: 18040
 * @date: 2023/2/22 15:57
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return null,则无此用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return null,则用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user 用户
     * @return -1,则表示存储失败，其他是指sql语句影响的行数
     */
    public int saveUser(User user);
}
