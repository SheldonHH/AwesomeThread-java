package com.sheldonhh.syn;

// will obtain -1
public class SafeBuyTicket {
    public static void main(String[] args) {
        SynBuyTicket station = new SynBuyTicket();
        new Thread(station, "A").start();
        new Thread(station, "B").start();
        new Thread(station, "C").start();
    }
}

class SynBuyTicket implements Runnable{
    private int ticketNums = 10;
    boolean flag = true; // stop triggered by flag
    @Override
    public void run() {
        // similiar to TestStop
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if(ticketNums<=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+" Obtain "+ticketNums--);
    }
}
