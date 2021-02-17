package com.cranajit.algorithms.longest_common_subsequesnce;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String x = "aabebcfded";
        System.out.println(LRS(x));
    }

    public static int LRS(String x) {
        String y = x;
        int[][] dp = new int[x.length()+1][y.length()+1];

        for(int cx = 0; cx < x.length()+1; cx++) {
            for(int cy = 0; cy < y.length()+1; cy++) {
                if(cx == 0 || cy == 0) {
                    dp[cx][cy] = 0;
                }
            }
        }

        for(int cx = 1; cx < x.length()+1; cx++) {
            for(int cy = 1; cy < y.length()+1; cy++) {
                if(x.charAt(cx-1) == y.charAt(cy-1) && cx != cy) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        return dp[x.length()][y.length()];
    }
}
