package com.sheldonhh.syn;

public class SafeBank extends Thread{
    public static void main(String[] args) {
        SAccount account = new SAccount(100, "Wedding Fund");

        SynWithdrawal you = new SynWithdrawal(account,50, "You");
        SynWithdrawal girl = new SynWithdrawal(account,100, "wife");

        you.start();
        girl.start();
    }
}

class SAccount{
    int balance;//
    String name; // cardname

    public SAccount(int balance, String name){
        this.balance = balance;
        this.name = name;
    }
}


class SynWithdrawal extends Thread{
    SAccount account;
    int amtToDraw;
    int nowMoney;

    public SynWithdrawal(SAccount account, int amtToDraw, String name){
        super(name);
        this.account = account;
        this.amtToDraw = amtToDraw;
    }

    // synchronized(Obj) default will lock this(shared resource)
    @Override
    public void run() {
        // lock CRUD object
        synchronized (account){
            System.out.println("Wedding Fund: "+account.balance);
            if(account.balance < amtToDraw){
                System.out.println(Thread.currentThread().getName()+" Sufficient Fund! ");
                return;
            }
            try  {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // account balance
            account.balance = account.balance - amtToDraw;
            // balance you own
            nowMoney = nowMoney + amtToDraw;

            System.out.println(account.name+" Remaining Balance is: "+account.balance);
            // Thread.currentThread().getName = this.getName()
            System.out.println(this.getName()+Thread.currentThread().getName());
            // this=Thread
        }


    }
}