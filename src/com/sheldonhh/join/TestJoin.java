package com.sheldonhh.join;

public class TestJoin implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i<10;i++){
            System.out.println("Thread VIP: "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // main thread
        for (int i = 0; i < 50; i++) {
            if(i==20){
                thread.join(); // cut the line
            }
            System.out.println("main:"+i);
        }
    }
}
