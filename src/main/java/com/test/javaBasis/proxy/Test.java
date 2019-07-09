package com.test.javaBasis.proxy;

public class Test {
    /**
     * 静态代理测试
     */
    @org.junit.Test
    public void  test1() {
        //目标对象
        UserDao userDao = new UserDao();
        //代理对象
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }

    /**
     * 动态代理测试
     */
    @org.junit.Test
    public void test2(){
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        proxy.save();
    }

    /**
     * Cglib子类代理
     */
    @org.junit.Test
    public void test(){
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }
}
