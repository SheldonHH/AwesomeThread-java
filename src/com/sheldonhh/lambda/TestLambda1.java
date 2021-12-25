package com.sheldonhh.lambda;

public class TestLambda1 {

    // 3. static internal class
    static class Like2 implements ILike{
        @Override
        public void lambda(){
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args){
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 4. scoped internal class
        class Like3 implements ILike{
            @Override
            public void lambda(){
                System.out.println("i like lambda2");
            }
        }
        like = new Like3();
        like.lambda();

        // 5. anomoyous internal class, depend on interface or parent class
        like = new ILike(){
            @Override
            public void lambda(){
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        // 6. simplify using lambda
        like = () -> {
            System.out.println("i like lambda4");
        };

        like.lambda();

    }
}


interface ILike{
    void lambda();
}


class Like implements ILike{
    @Override
    public void lambda(){
        System.out.println("i likee lambda");
    }
}