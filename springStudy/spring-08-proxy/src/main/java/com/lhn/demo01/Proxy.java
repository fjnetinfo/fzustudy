package com.lhn.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();

    }

    public void seeHouse() {
        System.out.println("中介带你去看房子!");
    }

    public void fare() {
        System.out.println("收中介费!");
    }

    public void hetong() {
        System.out.println("租赁合同!");
    }
}
