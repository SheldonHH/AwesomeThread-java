package com.sheldonhh.producer_consumer;

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Spectator(tv).start();
        
    }
}

class Player extends Thread{
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
              this.tv.play("House of Card");
            }else{
                this.tv.play("Google Ads");
            }
        }
    }
}

class Spectator extends Thread{
    TV tv;
    public Spectator(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}


class TV{
    //Player
    // Specatator
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Play:"+voice);
        this.notifyAll(); // notify spectator to watch
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Watch: "+voice);
        this.notifyAll(); //notify actor to play
        this.flag = !this.flag;
    }
}


