package com.sheldonhh.deadlock;

// multiple threads occupy the resource that counterparties need
public class SDeadLock {
    public static void main(String[] args) {
        SMakeup g1 = new SMakeup(0, "Cinderella");
        SMakeup g2 = new SMakeup(1, "Snow White");

        g1.start();
        g2.start();
    }
}


class SMakeup extends Thread{
    // only 1 piece of resource, use static to ensure
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; // choice
    String girlName;

    SMakeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        super.run();
        // makeup
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // obtain locks of eah other
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName+" obtain Lock of Lipstick");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.girlName+" obtain Lock of Mirror");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+" obtain Lock of Mirror");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.girlName+" obtain Lock of Lipstick");
            }
        }
    }
}