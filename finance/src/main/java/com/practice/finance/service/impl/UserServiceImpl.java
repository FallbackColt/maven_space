package com.practice.finance.service.impl;


import com.practice.finance.dao.UserDao;
import com.practice.finance.dao.impl.UserDaoImpl;
import com.practice.finance.pojo.User;
import com.practice.finance.service.UserService;

import java.util.List;


/**
 * @author: 18040
 * @date: 2023/2/24 23:00
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean registerUser(User user) {
        return (userDao.saveUser(user)==1);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }

    @Override
    public boolean updateUser(String username, String password, String rePassword) {
        return userDao.updateUserPassword(username, password, rePassword);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public boolean updateUserInfo(int ID, String username, String name, int department, String superior, String account) {
        return userDao.updateUserInfoByID(ID, username, name, department, superior, account);
    }

    @Override
    public List<User> queryUsersByUsername(String username) {
        return userDao.queryUsersByUsername(username);
    }

    @Override
    public boolean deleteUser(int ID, String username) {
        return userDao.deleteUserByIdAndUsername(ID, username);
    }
}
