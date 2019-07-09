package com.test.javaBasis.proxy;
/**
 * 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("before save");
        target.save();
        System.out.println("after save");
    }
}
