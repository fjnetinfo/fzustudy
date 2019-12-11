package com.lhn.demo03;

public class Client {
    public static void main(String[] args) {
        //真是角色
        Host host = new Host();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象
        proxyInvocationHandler.setRent(host);
        //动态生成的
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();

    }
}
