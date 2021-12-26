package com.sheldonhh.producer_consumer;

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}


class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("Produced: "+i+" Chicken");
        }
    }
}

class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Consume -->"+container.pop().id+" chicken");
        }
    }
}

class Chicken{
    int id;
    Chicken(int id){
        this.id = id;
    }
}

class SynContainer{
    // container size Buffer 缓冲区
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    // put consumers in product
    public synchronized void push(Chicken chicken){
        // full, consume
        if (count == chickens.length){
            // consumer consume, producer pause produce
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // not full, produce
        chickens[count] = chicken;
        count++;

        // notify Consumer to consume
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if(count == 0){
            try {
                wait(); // produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--; //consume
        Chicken chicken = chickens[count];
        return chicken;
    }
}