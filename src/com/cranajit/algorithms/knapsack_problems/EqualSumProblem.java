package com.cranajit.algorithms.knapsack_problems;

public class EqualSumProblem {
    public static void main(String[] args) {
        int[] items = {1,5,12,5,1,12};
        int count = items.length;
        System.out.println(equalSumRecur(items, count));
        System.out.println(equalSumTopdown(items, count));

    }

    public static boolean equalSumRecur(int[] items, int count) {
        int sum = 0;
        for(int i=0; i<items.length; i++) {
            sum += items[i];
        }

        if(sum % 2 != 0) {
            return false;
        }

        int findSum = sum/2;
        return subsetRec(items, findSum, count);
    }

    public static boolean subsetRec(int[] items, int sum, int count) {
        if(sum == 0) {
            return true;
        }

        if(count == 0) {
            return false;
        }

        if(items[count-1] <= sum) {
            return subsetRec(items, sum-items[count-1], count-1) ||
                    subsetRec(items, sum, count-1);
        } else {
            return subsetRec(items, sum, count-1);
        }
    }

    public static boolean equalSumTopdown(int[] items, int count) {
        int total = 0;
        for(int i=0; i<items.length; i++) {
            total+=items[i];
        }
        if(total % 2 != 0) return false;

        int sumToFind = total/2;
        boolean[][] dp = new boolean[sumToFind+1][count+1];

        for(int s = 0; s < sumToFind+1; s++) {
            for(int c = 0; c < count+1; c++) {

                if(c == 0) {
                    dp[s][c] = false;
                }

                if(s == 0) {
                    dp[s][c] = true;
                }
            }
        }

        for(int s = 1; s < sumToFind+1; s++) {
            for(int c = 1; c < count+1; c++) {
                if(items[c-1] <= s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] || dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sumToFind][count];
    }
}
