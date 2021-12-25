package com.sheldonhh.daemon;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // default: false, user thread (normal case)
        // true 守护线程

        thread.start(); // God daemon
        new Thread(you).start(); //user thread start
    }
}


class God implements Runnable{

    int counter = 0;
    @Override
    public void run(){
        while(true){ // only stop after a while
            System.out.println("God bless you");
            counter++;
//            if(counter >36500){
            System.out.println("Counter:"+counter);
//            }
        }


    }
}

class You implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 36500; i++) {
            System.out.println("happy");
        }
        System.out.println("Goodbye");
    }
}