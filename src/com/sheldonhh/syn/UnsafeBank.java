package com.sheldonhh.syn;

public class UnsafeBank extends Thread{
    public static void main(String[] args) {
        Account account = new Account(100, "Wedding Fund");

        Withdrawal you = new Withdrawal(account,50, "You");
        Withdrawal girl = new Withdrawal(account,100, "wife");

        you.start();
        girl.start();
    }
}

class Account{
    int balance;//
    String name; // cardname

    public Account(int balance, String name){
        this.balance = balance;
        this.name = name;
    }
}


class Withdrawal extends Thread{
    Account account;
    int amtToDraw;
    int nowMoney;

    public Withdrawal(Account account, int amtToDraw, String name){
        super(name);
        this.account = account;
        this.amtToDraw = amtToDraw;
    }

    @Override
    public void run() {
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