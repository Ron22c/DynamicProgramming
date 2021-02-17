package com.cranajit.algorithms.knapsack_problems;

public class MinimumSubsetDifference {
    public static void main(String args[]) {
        int[] items = {1,2,7,3,5};
        System.out.println(minSubsetDiffTopDown(items));
    }

    public static int minSubsetDiffTopDown(int[] items) {
        int sum = 0;
        int count = items.length;
        for(int i = 0; i < items.length; i++) {
            sum += items[i];
        }

        boolean[][] dp = new boolean[sum+1][count+1];

        for(int s = 0; s < sum+1; s++) {
            for(int c = 0; c < count+1; c++) {
                if(c == 0) {
                    dp[s][c] = false;
                }
                if(s == 0) {
                    dp[s][c] = true;
                }
            }
        }

        for(int s = 1; s<sum+1; s++) {
            for(int c = 1; c< count+1; c++) {
                if(items[c-1] <= s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] || dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        int[] sol = new int[(sum/2)+1];

        for(int s = 0; s < sum/2; s++) {
            if(dp[s][count]) {
                sol[s] = s;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<sol.length;i++) {
            min = Math.min(min, sum-2*(sol[i]));
        }

        return min;
    }
}
