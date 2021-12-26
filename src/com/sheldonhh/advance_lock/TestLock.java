package com.sheldonhh.advance_lock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}


class TestLock2 implements Runnable{
    int ticketNums = 10;
    @Override
    public void run() {
        while(true){
            if(ticketNums > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ticketNums);
            }else{
                break;
            }
        }
    }
}