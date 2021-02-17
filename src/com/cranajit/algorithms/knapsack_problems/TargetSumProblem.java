package com.cranajit.algorithms.knapsack_problems;

public class TargetSumProblem {
    public static void main(String[] args) {
        int[] items = {1, 1, 2, 3};
        int sum = 1;
        System.out.println(targetSum(items, sum));
    }

    public static int targetSum(int[] items, int sum) {
        int itemsSum = 0;
        int count = items.length;

        for(int i = 0; i < count; i++) {
            itemsSum += items[i];
        }

        int sumToFind = (itemsSum+sum)/2;

        int[][] dp = new int[sumToFind+1][count+1];
        for(int s = 0; s < sumToFind+1; s++) {
            for(int c = 0; c < count+1; c++) {
                if(c == 0) {
                    dp[s][c] = 0;
                }

                if(s == 0) {
                    dp[s][c] = 1;
                }
            }
        }

        for(int s = 1; s < sumToFind+1; s++) {
            for (int c = 1; c < count + 1; c++) {
                if(items[c-1] <= s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] + dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sumToFind][count];
    }
}
