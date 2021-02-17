package com.cranajit.algorithms.longest_common_subsequesnce;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "abfrc";
        System.out.println(printLCS(a,b,a.length(),b.length()));
    }

    public static String printLCS(String a, String b, int counta, int countb) {
        int[][] dp = new int[counta+1][countb+1];
        String result = "";
        String result1 = "";


        for(int ca = 0; ca < counta+1; ca++) {
            for(int cb = 0; cb < countb+1; cb++) {
                if(ca == 0 || cb == 0) {
                    dp[ca][cb] = 0;
                }
            }
        }

        for(int ca = 1; ca < counta+1; ca++) {
            for(int cb = 1; cb < countb+1; cb++) {
                if(a.charAt(ca -1) == b.charAt(cb-1)) {
                    dp[ca][cb] = 1+dp[ca-1][cb-1];
                    result1 += a.charAt(ca-1);
                } else {
                    dp[ca][cb] = Math.max(dp[ca][cb-1], dp[ca-1][cb]);
                }
            }
        }

        System.out.println(result1);

        int i = counta;
        int j = countb;

        while (i > 0 && j > 0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                result = a.charAt(i-1) + result;
                i--;
                j--;
            } else {
                if(dp[i][j-1] > dp[i-1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return result;
    }
}
