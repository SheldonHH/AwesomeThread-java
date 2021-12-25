package com.sheldonhh.lambda;

public class TestLamdba23 {

    public static void main(String[] args) {
        class Love implements ILove {
            @Override
            public void love(int a){
                System.out.println("i love you -->"+a);
            }
        }
        ILove love = new Love();
        love.love(2);
    }

}