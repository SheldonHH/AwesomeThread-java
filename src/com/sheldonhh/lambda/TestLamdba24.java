package com.sheldonhh.lambda;

public class TestLamdba24 {
    public static void main(String[] args){
        // 匿名内部类 anomoyous internal class
        ILove love = new ILove(){
            @Override
            public void love(int a){
                System.out.println("i love you --->"+a);
            }
        };
        love.love(2);
    }
}
