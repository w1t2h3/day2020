package com.wang.basic;

public interface UserDao {
    public void queryUserByNameAndPassword(String name,String password);

    public void saveUser(User user);
}
