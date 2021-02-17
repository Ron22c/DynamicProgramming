package com.cranajit.algorithms.unbounded_knapsack_problems;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int b[] = {2,4,3,5};
        int w = 9;
        int c = 4;
        int m [][] = {};
        System.out.println(unboundedKnapsackTopDown(a, b, w, c));
        System.out.println(unboundedKnapsackRec(a, b, w, c, new int[][]{}));
    }

    public static int unboundedKnapsackTopDown(int[] weight, int[] value, int capacity, int count) {
        int[][] dp = new int[capacity+1][count+1];

        for(int cap = 0; cap < capacity+1; cap++) {
            for(int cou = 0; cou < count+1; cou++) {
                if(cap == 0 || cou == 0) {
                    dp[cap][cou] = 0;
                }
            }
        }

        for(int cap = 1; cap < capacity+1; cap++) {
            for (int cou = 1; cou < count + 1; cou++) {
                if(weight[cou-1] <= cap) {
                    dp[cap][cou] = Math.max(value[cou-1] + dp[cap-weight[cou-1]][cou], dp[cap][cou-1]);
                } else {
                    dp[cap][cou] = dp[cap][cou-1];
                }
            }
        }

        return dp[capacity][count];
    }

    public static int unboundedKnapsackRec(int[] weight, int[] value, int capacity, int count, int[][]memo) {
        if(memo.length == 0) {
            memo = new int[capacity + 1][count + 1];
            for (int i = 0; i < capacity + 1; i++) {
                for (int j = 0; j < count + 1; j++) {
                    memo[i][j] = -1;
                }
            }
        }

        if (capacity == 0 || count == 0) {
            return 0;
        }

        if (weight[count - 1] <= capacity) {
            return memo[capacity][count] = Math.max(value[count - 1] + unboundedKnapsackRec(weight, value, capacity - weight[count - 1], count, memo),
                    unboundedKnapsackRec(weight, value, capacity, count - 1, memo));
        } else {
            return memo[capacity][count] = unboundedKnapsackRec(weight, value, capacity, count - 1, memo);
        }
    }
}
