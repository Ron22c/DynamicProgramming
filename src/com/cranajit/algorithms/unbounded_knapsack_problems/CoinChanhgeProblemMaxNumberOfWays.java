package com.cranajit.algorithms.unbounded_knapsack_problems;

public class CoinChanhgeProblemMaxNumberOfWays {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;

        System.out.println(coinChangeMaxTopDown(coins, sum));
        System.out.println(coinChangeRecMemo(coins, sum, coins.length, new int[][]{}));
    }

    public static int coinChangeMaxTopDown(int[] coins, int sum) {
        int count = coins.length;
        int[][] dp = new int[sum+1][count+1];

        for(int s = 0; s < sum+1; s++){
            for(int c = 0; c < count+1; c++) {
                if(c == 0) {
                    dp[s][c] = 0;
                }

                if(s == 0) {
                    dp[s][c] = 1;
                }
            }
        }

        for(int s = 1; s < sum+1; s++){
            for(int c = 1; c < count+1; c++) {
                if(coins[c-1] <= s) {
                    dp[s][c] = dp[s-coins[c-1]][c] + dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sum][count];
    }

    public static int coinChangeRecMemo(int[] coins, int sum, int count, int[][]memo) {
        if(memo.length == 0) {
            memo = new int[sum+1][count+1];
            for(int i =0; i < sum+1; i++) {
                for(int j = 0; j < count+1; j++) {
                    memo[i][j] = -1;
                }
            }
        }

        if(sum == 0) {
            return 1;
        }

        if(count == 0) {
            return 0;
        }

        if(memo[sum][count] != -1) {
            return memo[sum][count];
        }

        if(coins[count-1] <= sum) {
            return memo[sum][count] = coinChangeRecMemo(coins, sum-coins[count-1], count, memo) +
                    coinChangeRecMemo(coins, sum, count-1, memo);
        } else {
            return memo[sum][count] = coinChangeRecMemo(coins, sum, count-1, memo);
        }
    }
}
