package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/2/22 15:55
 */
public class User {
    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 真实姓名
    private String name;
    // 职位
    private int department;
    // 直属上级
    private String superior;
    // 打款账号
    private String account;


    public User() {
    }

    public User(String username, String password, String name, int department, String superior, String account) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.superior = superior;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


}
