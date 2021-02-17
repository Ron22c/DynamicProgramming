package com.cranajit.algorithms.longest_common_subsequesnce;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "agbcba";
        System.out.println(longestPalindromicSubSequence(x));
    }

    public static int longestPalindromicSubSequence(String x) {
        StringBuilder y = new StringBuilder();
        String subsequence = "";
        for(int i = 0; i<x.length(); i++) {
            y.insert(0, x.charAt(i));
        }

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
                if(x.charAt(cx-1) == y.charAt(cy-1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        int i = x.length();
        int j = y.length();
        while(i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                subsequence += x.charAt(i - 1);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        System.out.println(subsequence);
        return dp[x.length()][y.length()];
    }
}
