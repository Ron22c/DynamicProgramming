package com.cranajit.algorithms.unbounded_knapsack_problems;

public class CoinChangeMinNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {4};
        int sum=6;

        System.out.println(coinChangeMinNoCoinsTopDown(coins, sum));
    }

    public static int coinChangeMinNoCoinsTopDown(int[] coins, int sum) {
        int count = coins.length;

        int[][] dp = new int[sum+1][count+1];
        for(int s = 0; s < sum+1; s++) {
            for(int c =0; c < count+1; c++) {
                if(sum == 0) {
                    dp[s][c] = 0;
                }
                if(count == 0) {
                    dp[s][c] = Integer.MAX_VALUE-1;
                }
            }
        }

        for(int i = 1; i < sum+1; i++) {
            if(i%coins[0] == 0) {
                dp[i][1] = i/coins[0];
            } else {
                dp[i][1] = Integer.MAX_VALUE-1;
            }
        }

        for(int s = 1; s < sum+1; s++) {
            for (int c = 2; c < count + 1; c++) {
                if(coins[c-1] <= s) {
                    dp[s][c] = Math.min(dp[s-coins[c-1]][c] + 1, dp[s][c-1]);
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sum][count] == Integer.MAX_VALUE - 1 ? -1 : dp[sum][count];
    }
}
