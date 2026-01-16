package com.spring.springboot_demo;

public class User {
    private String username;
    private Integer usernum;
    private String birthday;

    public User(String username, Integer usernum, String birthday) {
        this.username = username;
        this.usernum = usernum;
        this.birthday = birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernum(Integer usernum) {
        this.usernum = usernum;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public Integer getUsernum() {
        return usernum;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", usernum=" + usernum +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
