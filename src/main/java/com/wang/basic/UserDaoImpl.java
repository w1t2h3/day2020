package com.wang.basic;

public class UserDaoImpl implements UserDao{
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("query user name = " + name + ",password = " + password);
    }

    public void saveUser(User user) {
        System.out.println("insert into user = " + user);
    }
}
