package com.practice.finance.dao;


import com.practice.finance.pojo.User;

import java.util.List;

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
     * 查询所有用户信息
     * @return
     */
    public List<User> queryAllUser();

    /**
     * 保存用户信息
     * @param user 用户
     * @return -1,则表示存储失败，其他是指sql语句影响的行数
     */
    public int saveUser(User user);

    /**
     * 修改密码
     * @param username 用户名
     * @param password 原密码
     * @param rePassword 新的密码
     * @return true, 修改成功；false, 修改失败
     */
    public boolean updateUserPassword(String username, String password, String rePassword);


    /**
     * 更改信息
     * @param ID 索引
     * @param username 用户名
     * @param name 姓名
     * @param department 部门ID
     * @param superior 上级
     * @param account 账户
     * @return true, 修改成功；false, 修改失败
     */
    public boolean updateUserInfoByID(int ID, String username, String name, int department, String superior, String account);



    /**
     * 根据用户名模糊查询用户信息
     * @param username 用户名
     * @return null,则无此用户
     */
    public List<User> queryUsersByUsername(String username);


    /**
     * 根据用户名和ID删除用户
     * @param ID 索引
     * @param username 用户名
     * @return
     */
    public boolean deleteUserByIdAndUsername(int ID, String username);



}
