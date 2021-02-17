package com.cranajit.algorithms.longest_common_subsequesnce;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        System.out.println(printSCS(a,b));
    }

    public static String printSCS(String x, String y) {
        int countx = x.length();
        int county = y.length();
        String res = "";

        int[][] dp = new int[countx+1][county+1];

        for(int cx = 0; cx < countx+1; cx++) {
            for(int cy = 0; cy < county+1; cy++) {
                if(cx == 0 || cy == 0) {
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

        while(countx > 0 && county > 0) {
            if(x.charAt(countx-1) == y.charAt(county-1)) {
                res = x.charAt(countx-1) + res;
                countx--;
                county--;
            } else {
                if(dp[countx][county-1] > dp[countx-1][county]) {
                    res = y.charAt(county-1) + res;
                    county--;
                } else {
                    res = x.charAt(countx-1) + res;
                    countx--;
                }
            }
        }
        while(countx > 0) {
            res = x.charAt(countx-1) + res;
            countx--;
        }
        while(county > 0) {
            res = y.charAt(county-1) + res;
            county--;
        }
        return res;
    }
}
