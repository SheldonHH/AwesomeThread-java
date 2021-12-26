package com.sheldonhh.static_proxy;

/*
Proxy and You implement same interface
*/
public class StaticProxy {
    public static void main(String[] args) {

//        You you = new You();
        //        ProxyCompany proxyCompany = new ProxyCompany(new You());
//        proxyCompany.HappyMarry();

        new Thread(()-> System.out.println("LOVEEEEEE")).start();
        new ProxyCompany(new You()).HappyMarry();

    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("Ring Exchange");

        System.out.println("Kiss ");
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