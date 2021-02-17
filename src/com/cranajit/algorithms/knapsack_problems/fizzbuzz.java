package com.cranajit.algorithms.knapsack_problems;

public class fizzbuzz {
    public static void main(String[] args) {
        fizzBuzzExp(20);
    }

    public static void fizzBuzzExp(int num) {
        int c3=0;
        int c5=0;
        for(int i = 1; i<=num; i++) {
            String d = "";
            c3++;
            c5++;
            if(c3 == 3) {
                d += "fizz";
                c3 = 0;
            }
            if(c5 == 5) {
                d += "buzz";
                c5 = 0;
            }
            if(d == "") {
                System.out.println(i);
            } else {
                System.out.println(d);
            }
        }
    }

    public static void fizzbuzznormal(int number) {
        for(int i=1; i<=number; i++) {
            if(i%15==0) {
                System.out.println("fizzbuzz");
            } else if(i%5==0) {
                System.out.println("buzz");
            } else if(i%3==0) {
                System.out.println("fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzbuzzext(int num) {
        for (int i = 1; i <= num; i++) {
            String d = "";
            if (i % 3 == 0) {
                d += "fizz";
            }
            if (i % 5 == 0) {
                d += "buzz";
            }
            if (d == "") {
                System.out.println(i);
            } else {
                System.out.println(d);
            }
        }
    }
}
