package com.cranajit.algorithms.knapsack_problems;

public class CountSubsetSumWithGivenDifference {
    public static void main(String args[]) {
        int[] items = {1,1,2,3};
        System.out.println(countSubsetWithGivenDiffTopDown(items, 1));
        System.out.println(countSubsetWithGivenDiffRec(items, 1));
    }

    public static int countSubsetWithGivenDiffTopDown(int[] items, int diff) {
        int sum = 0;
        int count = items.length;
        for(int i=0; i<count; i++) {
            sum += items[i];
        }

        int sumDiff = (diff+sum)/2;

        int[][]dp = new int[sumDiff+1][count+1];

        for(int s = 0; s < sumDiff+1; s++) {
            for(int c = 0; c < count+1; c++) {
                if(c == 0) {
                    dp[s][c] = 0;
                }

                if(s == 0) {
                    dp[s][c] = 1;
                }
            }
        }

        for(int s = 1; s < sumDiff+1; s++) {
            for(int c = 1; c < count+1; c++) {
                if(items[c-1] <= s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] + dp[s][c-1];
                } else {
                    dp[s][c] = dp[s][c-1];
                }
            }
        }

        return dp[sumDiff][count];
    }

    public static int countSubsetWithGivenDiffRec(int[] items, int diff) {
        int sum = 0;
        int count = items.length;
        for(int i=0; i< count; i++) {
            sum += items[i];
        }

        int sumDiff = (diff+sum)/2;
        return countSubsetSumWithRec(items, sumDiff, count, new int[][]{});
    }

    public static int countSubsetSumWithRec(int[] items, int sum, int count, int[][] memo) {
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
            return countSubsetSumWithRec(items, sum-items[count-1], count-1, memo) +
                    countSubsetSumWithRec(items, sum, count-1, memo);
        } else {
            return countSubsetSumWithRec(items, sum, count-1, memo);
        }
    }
}
