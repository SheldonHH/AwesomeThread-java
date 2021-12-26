package com.sheldonhh.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        //1. create thread pool
        // ExecuteService, Executor
        ExecutorService service = Executors.newFixedThreadPool(10);

        // execute runnable execute() method
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 2. close conn
        service.shutdown();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}