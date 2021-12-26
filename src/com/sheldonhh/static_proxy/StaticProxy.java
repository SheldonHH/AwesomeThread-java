package com.sheldonhh.static_proxy;

/*
Proxy and You implement same interface
*/
public class StaticProxy {
    public static void main(String[] args) {
        ProxyCompany proxyCompany = new ProxyCompany(new You());
        proxyCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("Start");
    }
}

// PROXY
class ProxyCompany implements Marry{
    private Marry target;

    public ProxyCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("Finish");
    }

    private void before() {
        System.out.println("Before");
    }
}