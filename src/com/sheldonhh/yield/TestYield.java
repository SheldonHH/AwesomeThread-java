package com.sheldonhh.yield;

/*
礼让不一定成功看CPU心情
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"Stop");

    }
}
