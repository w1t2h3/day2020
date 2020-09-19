package com.wang.basic;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public void login(String name, String password) {
        userDao.queryUserByNameAndPassword(name,password);
    }

    public void register(User user) {
        userDao.saveUser(user);
    }
}
