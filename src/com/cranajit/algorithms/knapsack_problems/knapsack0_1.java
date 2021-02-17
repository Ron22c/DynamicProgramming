package com.cranajit.algorithms.knapsack_problems;

public class knapsack0_1 {
    public static void main(String args[]) {
        int a[] = {1,2,3,4};
        int b[] = {2,4,3,5};
        int w = 9;
        int c = 4;
        int m [][] = {};

        System.out.println(knapsackTopDown(a, b, w, c));
        System.out.println(knapsackRecursive(a, b, w, c));
        System.out.println(knapsackMemoization(a, b, w, c, m));
    }

    public static int knapsackTopDown(int[] weight, int value[], int capacity, int count) {
        int dp[][] = new int[count + 1][capacity + 1];

        for(int cou = 0; cou < count+1; cou++) {
            for(int cap = 0; cap < capacity +1; cap++) {
                if(cap == 0 || cou == 0) {
                    dp[cou][cap] = 0;
                }
            }
        }

        for(int cou = 1; cou < count+1; cou++) {
            for(int cap = 1; cap < capacity+1; cap++) {
                if(weight[cou - 1] <= cap) {
                    dp[cou][cap] = Math.max(value[cou-1] + dp[cou-1][cap - weight[cou-1]],
                            dp[cou-1][cap]);
                } else {
                    dp[cou][cap] = dp[cou-1][cap];
                }
            }
        }

        return dp[count][capacity];
    }

    public static int knapsackRecursive(int weight[], int value[], int capacity, int count) {
        if(capacity == 0 || count == 0) {
            return 0;
        }

        if(weight[count-1] <= capacity) {
            return Math.max(value[count-1] + knapsackRecursive(weight, value, capacity-weight[count-1], count-1),
                    knapsackRecursive(weight, value, capacity, count-1));
        } else {
            return knapsackRecursive(weight, value, capacity, count-1);
        }
    }

    public static int knapsackMemoization(int weight[], int value[], int capacity, int count, int[][] memo) {
        if(memo.length == 0) {
            memo = new int[capacity+1][count+1];
            for(int i =0; i<capacity+1; i++) {
                for(int j = 0; j<count+1; j++) {
                    memo[i][j] = -1;
                }
            }
        }

        if(capacity == 0 || count == 0) {
            return 0;
        }

        if(memo[capacity][count] != -1) {
            return memo[capacity][count];
        }

        if(weight[count-1] <= capacity) {
            return memo[capacity][count] = Math.max(value[count-1] + knapsackMemoization(weight, value, capacity - weight[count-1], count-1, memo),
                    knapsackMemoization(weight, value, capacity, count-1, memo));
        } else {
            return memo[capacity][count] = knapsackMemoization(weight, value, capacity, count-1, memo);
        }
    }
}
