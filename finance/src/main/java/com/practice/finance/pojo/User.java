package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/2/22 15:55
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String position;

    public User() {
    }

    public User(Integer id, String username, String password, String position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
