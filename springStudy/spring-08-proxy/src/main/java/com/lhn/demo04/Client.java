package com.lhn.demo04;

import com.lhn.demo02.UserService;
import com.lhn.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userService);//设置要代理的对象

        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();

        proxy.delete();
    }
}
