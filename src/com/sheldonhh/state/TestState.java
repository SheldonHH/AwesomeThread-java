package com.sheldonhh.state;

public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        // Observe State
        Thread.State state = thread.getState();
        System.out.println(state); // new


        // Observe after initialization
        thread.start();
        state = thread.getState();
        System.out.println(state); // Run
        int counter = 0;
        while(state != Thread.State.TERMINATED){ // as lng as thread not stop, keep output
            try {
                Thread.sleep(100);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState(); // update thread statel
            System.out.println("counter: "+counter);
            System.out.println(state);
        }
    }
}
