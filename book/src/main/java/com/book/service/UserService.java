package com.book.service;

import com.book.pojo.User;

/**
 * @author: 18040
 * @date: 2023/2/21 12:45
 */
public interface UserService {

    /**
     * 注册用户
     * @param user 用户
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user 用户名
     * @return null,登录失败
     */
    public User login(User user);


    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return true,用户名存在；false,用户名可用
     */
    public boolean existsUsername(String username);

}
