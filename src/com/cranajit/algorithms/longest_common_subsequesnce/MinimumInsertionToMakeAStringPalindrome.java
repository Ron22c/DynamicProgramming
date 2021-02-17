package com.cranajit.algorithms.longest_common_subsequesnce;

public class MinimumInsertionToMakeAStringPalindrome {

    public static void main(String[] args) {
        String x = "Ranajit";
        String y = "Chandra";
        System.out.println(minNumInsertionToMakeNumberPalindrome(x));
        System.out.println(lcs(x, y, x.length(), y.length(), new int[][]{}));
    }

    public static int minNumInsertionToMakeNumberPalindrome(String x) {
        String y = "";

        for(int i = 0; i < x.length(); i++) {
            y = x.charAt(i) + y;
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
                if(x.charAt(cx - 1) == y.charAt(cy - 1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }
        System.out.println(dp[x.length()][y.length()]);
        return x.length() - dp[x.length()][y.length()];
    }

    public static int lcs(String x, String y, int countX, int countY, int[][]memo) {
        if(memo.length == 0) {
            memo = new int[countX+1][countY+1];
            for(int cx = 0; cx < x.length()+1; cx++) {
                for (int cy = 0; cy < y.length() + 1; cy++) {
                    memo[cx][cy] = -1;
                }
            }
        }

        if(countX == 0 || countY == 0) {
            return 0;
        }

        if(memo[countX][countY] != -1) {
            return memo[countX][countY];
        }

        if(x.charAt(countX-1) == y.charAt(countY-1)) {
            return memo[countX][countY] = 1 + lcs(x, y, countX-1, countY-1, memo);
        } else {
            return memo[countX][countY] = Math.max(lcs(x, y, countX, countY-1, memo), lcs(x, y, countX-1, countY, memo));
        }
    }
}
