package com.spring5.test.service;

import com.spring5.test.dao.UserDao;

/**
 * @author: 18040
 * @date: 2023/4/6 20:50
 */
public class UserService {

    // 创建USerDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add......");
        userDao.update();
    }

}
