package com.sheldonhh.deadlock;

// multiple threads occupy the resource that counterparties need
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "Cinderella");
        Makeup g2 = new Makeup(1, "Snow White");
    }
}

class Lipstick{

}

class Mirror{

}

class Makeup extends Thread{
    // only 1 piece of resource, use static to ensure
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; // choice
    String girlName;

    Makeup(int choice, String girlName){
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
                synchronized (mirror){
                    System.out.println(this.girlName+" obtain Lock of Mirror");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+" obtain Lock of Mirror");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.girlName+" obtain Lock of Lipstick");
                }
            }
        }
    }
}