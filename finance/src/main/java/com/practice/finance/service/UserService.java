package com.practice.finance.service;

import com.practice.finance.pojo.User;

import java.util.List;

/**
 * @author: 18040
 * @date: 2023/2/24 22:53
 */
public interface UserService {

    /**
     * 注册用户
     * @param user 用户
     */
    public boolean registerUser(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return null,登录失败
     */
    public User login(String username, String password);


    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return true,用户名存在；false,用户名可用
     */
    public boolean existsUsername(String username);



    /**
     * 修改密码
     * @param username 用户名
     * @param password 原密码
     * @param rePassword 新的密码
     * @return true, 修改成功；false, 修改失败
     */
    public boolean updateUser(String username, String password, String rePassword);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryAllUser();


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
    public boolean updateUserInfo(int ID, String username, String name, int department, String superior, String account);


    /**
     * 根据用户名模糊查询用户
     * @param username 用户名
     * @return
     */
    public List<User> queryUsersByUsername(String username);


    /**
     * 根据用户名和ID删除用户
     * @param ID 索引
     * @param username 用户名
     * @return
     */
    public boolean deleteUser(int ID, String username);

}
