package com.sheldonhh.sleep;

public class TestSleep implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run(){
        while(true){
            if(ticketNums <= 0){
                break;
            }
            // simulate delay
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+ " Obtain #"+ticketNums+" ticket");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket, "A").start();
        new Thread(ticket, "B").start();
        new Thread(ticket, "C").start();
    }
}
