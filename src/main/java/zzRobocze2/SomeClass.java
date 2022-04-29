package zzRobocze2;

import zzRobocze.SomeInterface;

public class SomeClass {
    public static void main(String[] args) {

        FirstClas firstClas = new FirstClas();
        SecondClass secondClass = new SecondClass();

        System.out.println(firstClas.equals(secondClass));

    }
    public static class FirstClas{
        int x;
        public void someMethod(){
            System.out.println("g");
        }
    }

    public static class SecondClass{
        int x = 0;
        public void someMethod(){
            System.out.println("g");
        }
    };




}
