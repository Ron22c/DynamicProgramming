package com.cranajit.algorithms.unbounded_knapsack_problems;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String args[]) {
        int[] prices = {1,2,5};
        int length = 3;
        System.out.println(rodCutTopDown(prices, length));
    }

    public static int rodCutTopDown(int[] prices, int length) {
        int[] lengtharr = new int[length];
        int count = prices.length;
        for (int i = 0; i < length; i++) {
            lengtharr[i] = i+1;
        }
        
        Arrays.stream(lengtharr).forEach(System.out::println);

        int[][] dp = new int[length+1][count+1];
        for(int l = 0; l < length+1; l++) {
            for(int c = 0; c < count+1; c++) {
                if(c == 0 || l == 0) {
                    dp[l][c] = 0;
                }
            }
        }

        for(int l = 1; l < length+1; l++) {
            for(int c = 1; c < count+1; c++) {
                if(lengtharr[c-1] <= l) {
                    dp[l][c] = Math.max(prices[c-1] + dp[l - lengtharr[c-1]][c], dp[l][c-1]);
                } else {
                    dp[l][c] = dp[l][c-1];
                }
            }
        }

        return dp[length][count];
    }
}
