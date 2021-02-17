package com.cranajit.algorithms.longest_common_subsequesnce;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "gabcde";
        String y = "wabcfce";
        System.out.println(longestCommonSubStringRec(x, y, x.length(), y.length(), new int[][]{}, 0));
        System.out.println(largestCommonSubstring(x, y, x.length(), y.length()));
    }

    public static int largestCommonSubstring(String x, String y, int countx, int county) {
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
                    dp[cx][cy] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int cx = 0; cx < countx+1; cx++) {
            for(int cy = 0; cy < county+1; cy++) {
                max = Math.max(dp[cx][cy], max);
            }
        }

        return max;
    }

    //This is not correct
    public static int longestCommonSubStringRec(String x, String y, int countx, int county, int[][]memo, int max) {
        if(memo.length == 0) {
            memo = new int[countx+1][county+1];
            for(int i = 0; i < countx+1; i++) {
                for(int j = 0; j < county+1; j++) {
                    memo[i][j] = -1;
                }
            }
        }
        if(countx == 0 || county == 0) {
            return 0;
        }

        if(memo[countx][county] != -1) {
            return memo[countx][county];
        }

        if(x.charAt(countx-1) == y.charAt(county-1)) {
            memo[countx][county] = Math.max(max, 1 + longestCommonSubStringRec(x, y, countx-1, county-1, memo, max));
            return memo[countx][county];
        } else {
            return memo[countx][county] = 0;
        }
    }
}
