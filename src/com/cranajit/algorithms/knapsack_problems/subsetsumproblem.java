package com.cranajit.algorithms.knapsack_problems;

public class subsetsumproblem {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4};
        int sum = 8;
        int count = 4;

        System.out.println(subsetSumRecurssion(arr, sum, count));
        System.out.println(subsetSumTopdown(arr, sum, count));

    }

    public static boolean subsetSumRecurssion(int items[], int sum, int count) {
        if(sum == 0 && count == 0) {
            return true;
        }

        if(sum == 0) {
            return true;
        }

        if(count == 0) {
            return false;
        }

        if(items[count-1] <= sum) {
            return subsetSumRecurssion(items, sum - items[count-1], count-1) ||
                    subsetSumRecurssion(items, sum, count-1);
        } else {
            return subsetSumRecurssion(items, sum, count-1);
        }
    }

    public static boolean subsetSumTopdown(int[] items, int sum, int count) {
        boolean[][] dp = new boolean[sum+1][count+1];

        for(int s=0; s<sum+1; s++) {
            for(int c=0; c<count+1; c++) {
                if(c==0) {
                    dp[s][c] = false;
                }

                if(s==0) {
                    dp[s][c] = true;
                }
            }
        }

        for(int s=1; s<sum+1; s++) {
            for (int c = 1; c < count + 1; c++) {
                if(items[c-1] <=s) {
                    dp[s][c] = dp[s-items[c-1]][c-1] || dp[s][c-1];
                } else {
                    dp[s][c]=dp[s][c-1];
                }
            }
        }

        return dp[sum][count];
    }

    public static boolean subsetsumproblemMemo(int[] items, int sum, int count, boolean[][] memo) {
//        if(memo.length == 0) {
//            memo = new int[sum+1][count+1];
//            for(int i =0; i < sum+1; i++) {
//                for(int j = 0; j < count + 1; j++) {
//                    memo[i][j] = ;
//                }
//            }
//        }
//
//        if(sum == 0) {
//            return true;
//        }
//
//        if(count == 0) {
//            return false;
//        }
//
//        if(items[count-1] <= sum) {
//            return memo[sum][count] = subsetsumproblemMemo(items, sum - items[count-1], count-1, memo) ||
//                    subsetsumproblemMemo(items, sum, count-1, memo);
//        } else {
//
//        }
        return false;
    }
}
