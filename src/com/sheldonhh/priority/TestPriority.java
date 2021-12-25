package com.sheldonhh.priority;

public class TestPriority extends Thread {
    public static void main(String[] args) {
        // set default priority for main thread
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());  // NORM_PRIORITY=5
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        // set priority, then start
        t1.start(); // main-->5 execute first

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
        // MAX_PRIORITY=10
        // MIN_PRIORITY=1
        // NORM_PRIORITY=5
        // getPriority() setPriority(int xxx)


        t5.setPriority(7);
        t5.start();

        t6.setPriority(8);
        t6.start();
    // error
//        t5.setPriority(-1);
//        t5.start();
//
//        t6.setPriority(11);
//        t6.start();

    }


}
class MyPriority implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
