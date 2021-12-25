package com.sheldonhh.stop;

public class TestStop implements Runnable{
//    1. flag
    private boolean flag = true;
    public void run(){
        int i = 0;
        while (flag){
            System.out.println("run....Thread"+i++);
        }
    }
//2. customizes stop by flag
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args){
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for(int i = 0; i < 1000; i++){
            if(i == 900){
                testStop.stop();
                System.out.println("stop aat "+i);
            }
        }
    }
}
