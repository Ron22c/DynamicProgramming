package com.cranajit.algorithms.longest_common_subsequesnce;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(SCSS(a,b,a.length(),b.length()));
    }

    public static int SCSS(String x, String y, int countx, int county) {
        int[][]dp = new int[countx+1][county+1];
        for(int cx = 0; cx < countx+1; cx++) {
            for(int cy = 0; cy < county+1; cy++) {
                if(cx == 0 || cy ==0) {
                    dp[cx][cy] = 0;
                }
            }
        }

        for(int cx = 1; cx < countx+1; cx++) {
            for(int cy = 1; cy < county+1; cy++) {
                if(x.charAt(cx-1) == y.charAt(cy-1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        System.out.println("LCS: "+dp[countx][county]);
        return countx+county-dp[countx][county];
    }
}
