package com.cranajit.algorithms.longest_common_subsequesnce;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String a = "xyz";
        String b = "avxerywerz";
        System.out.println(spm(a, b));
    }

    public static boolean spm(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int cx = 0; cx < a.length()+1; cx++) {
            for(int cy = 0; cy < b.length()+1; cy++) {
                if(cx == 0 || cy == 0) {
                    dp[cx][cy] = 0;
                }
            }
        }

        for(int cx = 1; cx < a.length()+1; cx++) {
            for(int cy = 1; cy < b.length()+1; cy++) {
                if(a.charAt(cx-1) == b.charAt(cy-1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        if(dp[a.length()][b.length()] == a.length()) return true;
        else return false;
    }
}
