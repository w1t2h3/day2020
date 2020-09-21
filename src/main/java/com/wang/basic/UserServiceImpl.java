package com.wang.basic;

public class UserServiceImpl implements UserService {

    //硬编码，高耦合
//    private UserDao userDao = new UserDaoImpl();
    //使用第二种工厂类创建对象
//    private UserDao userDao = BeanFactory.getUserDao();
    //使用第三种通用工厂创建对象
    private UserDao userDao = (UserDao) BeanFactory.getBean("userDao");

    public void login(String name, String password) {
        userDao.queryUserByNameAndPassword(name,password);
    }

    public void register(User user) {
        userDao.saveUser(user);
    }
}
