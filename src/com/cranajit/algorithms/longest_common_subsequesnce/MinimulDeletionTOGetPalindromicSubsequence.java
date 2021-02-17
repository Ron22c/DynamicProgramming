package com.cranajit.algorithms.longest_common_subsequesnce;

public class MinimulDeletionTOGetPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "agbcba";
        System.out.println(minDelPal(x));
    }

    public static int minDelPal(String x) {
        StringBuilder y = new StringBuilder();
        for(int i = 0; i < x.length(); i++) {
            y.insert(0, x.charAt(i));
        }

        System.out.println(y);

        int[][]dp = new int [x.length()+1][y.length()+1];

        for(int cx = 0; cx < x.length()+1; cx++) {
            for(int cy = 0; cy < y.length()+1; cy++) {
                if(cx == 0 || cy == 0) {
                    dp[cx][cy] = 0;
                }
            }
        }

        for(int cx = 1; cx < x.length()+1; cx++) {
            for(int cy = 1; cy < y.length()+1; cy++) {
                if(x.charAt(cx-1) == y.charAt(cy-1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        return x.length() - dp[x.length()][y.length()];
    }
}
