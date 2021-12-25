package com.sheldonhh.lambda;

public class TestLamdba25 {
    public static void main(String[] args){
        // 匿名内部类 anomoyous internal class
        ILove love = (int a) -> {
                System.out.println("i love you --->"+a);
        };
        love = (a) -> {
            System.out.println("i love you --->"+a);
        };

        love = a -> {
            System.out.println("i love you --->"+a);
        };

        love = a ->  System.out.println("i love you --->"+a);

        love.love(521);
        // 前提是functional interface
    }
}
