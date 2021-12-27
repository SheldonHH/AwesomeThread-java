package com.sheldonhh.race;

public class Race implements Runnable {
    private static String winner;
    @Override
    public void run(){
        for(int i = 0; i <= 100; i++){
            if( Thread.currentThread().getName().equals("Harrer") && i%10==0){
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if(flag){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"--> run"+i+"step");
        }
    }

    private boolean gameOver(int steps){
        if(winner != null){
            return true;
        }{
            if(steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is"+winner);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Race race = new Race();
        new Thread(race, "Harrer").start();
        new Thread(race, "Turtle").start();
    }
}