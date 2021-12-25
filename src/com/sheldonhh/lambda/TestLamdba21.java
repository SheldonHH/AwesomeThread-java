package com.sheldonhh.lambda;

public class TestLamdba21 {

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);
    }
}

class Love implements ILove {
    @Override
    public void love(int a){
        System.out.println("i love you -->"+a);
    }
}
