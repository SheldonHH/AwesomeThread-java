package com.sheldonhh.race;

public class LearnCoding implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 20; i++){
            System.out.println("Coding: "+i);
        }
    }

    public static void main(String[] args){
        LearnCoding thread3 = new LearnCoding();

        // create thread object
        // Thread thread = new Thread(thread3);
        // thread.start();
        new Thread(thread3).start();

        for(int i = 0; i < 100; i++){
            System.out.println("Learning: "+i);
        }
    }

}