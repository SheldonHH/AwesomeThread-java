package com.sheldonhh.lambda;

public class TestLamdba2 {
    static class Love implements ILove {
        @Override
        public void love(int a){
            System.out.println("i love you -->"+a);
        }
    }
    public static void main(String[] args) {
        ILove love = new Love();
        love.love(2);
    }

}
