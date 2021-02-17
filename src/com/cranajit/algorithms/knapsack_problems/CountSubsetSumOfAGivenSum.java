package com.cranajit.algorithms.knapsack_problems;

public class CountSubsetSumOfAGivenSum {
    public static void main(String args[]) {
        int[] items = {2,3,5,7,3};
        int sum = 10;
        int[][] memo = {};
        int count = items.length;
        System.out.println(countSubsetSumRec(items, sum, count));
        System.out.println(countSubsetsumMemo(items, sum, count, memo));
        System.out.println(countSubsetSumTopDown(items, sum, count));

    }

    public static int countSubsetSumTopDown(int[] items, int sum, int count) {
        int[][] dp = new int[sum+1][count+1];
        for(int s = 0; s < sum+1; s++) {
            for(int c = 0; c < count+1; c++) {
                if(c == 0) {
                    dp[s][c] = 0;
                }
                if(s == 0) {
                    dp[s][c] = 1;
                }
            }
        }

        for(int s = 1; s < sum+1; s++) {
            for(int c = 1; c < count+1; c++) {
                if(items[c-1] <= s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] + dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sum][count];
    }

    public static int countSubsetsumMemo(int[] items, int sum, int count, int[][] memo) {
        if(memo.length == 0) {
            memo = new int[sum+1][count+1];
            for(int i = 0; i < sum+1; i++) {
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

        if(items[count-1] <= sum) {
            return countSubsetsumMemo(items, sum-items[count-1], count-1, memo) +
                    countSubsetsumMemo(items, sum, count-1, memo);
        } else {
            return countSubsetsumMemo(items, sum, count-1, memo);
        }
    }

    public static int countSubsetSumRec(int[] items, int sum, int count) {
        if(sum == 0) {
            return 1;
        }

        if(count == 0) {
            return 0;
        }

        if(items[count-1] <= sum) {
            return countSubsetSumRec(items, sum-items[count-1], count-1) +
                    countSubsetSumRec(items, sum, count-1);
        } else {
            return countSubsetSumRec(items, sum, count-1);
        }
    }
}
