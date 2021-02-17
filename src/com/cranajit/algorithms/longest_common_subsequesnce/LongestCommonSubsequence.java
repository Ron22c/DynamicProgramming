package com.cranajit.algorithms.longest_common_subsequesnce;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "arbdcgje";
        String y = "asbzccf";
        System.out.println(LCS(x, y, x.length(), y.length()));
        System.out.println(LCSTopDown(x, y, x.length(), y.length()));
        System.out.println(LCSMemo(x, y, x.length(), y.length(), new int[][]{}));
    }

    public static int LCSTopDown(String x, String y, int countx, int county) {
        int[][]dp = new int[countx+1][county+1];
        for(int cx = 0; cx < countx+1; cx++) {
            for(int cy = 0; cy < county+1; cy++) {
                if(cx == 0 || cy == 0) {
                    dp[cx][cy] = 0;
                }
            }
        }

        for(int cx = 1; cx < countx+1; cx++) {
            for (int cy = 1; cy < county+1; cy++) {
                if(x.charAt(cx-1) == y.charAt(cy-1)) {
                    dp[cx][cy] = 1 + dp[cx-1][cy-1];
                } else {
                    dp[cx][cy] = Math.max(dp[cx][cy-1], dp[cx-1][cy]);
                }
            }
        }

        return dp[countx][county];
    }

    public static int LCS(String x, String y, int countX, int countY) {
        if(countX == 0 || countY == 0) {
            return 0;
        }

        if(x.charAt(countX-1) == y.charAt(countY-1)) {
            return LCS(x, y, countX-1, countY-1) + 1;
        } else {
            return Math.max(LCS(x, y, countX, countY-1), LCS(x, y, countX-1, countY));
        }
    }

    public static int LCSMemo(String x, String y, int countX, int countY, int[][] memo) {
        if(memo.length == 0) {
            memo = new int[countX+1][countY+1];
            for(int i = 0; i < countX+1; i++) {
                for(int j = 0; j < countY+1; j++) {
                    memo[i][j] = -1;
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
            return memo[countX][countY] = 1 + LCSMemo(x, y, countX-1, countY-1, memo);
        } else {
            return memo[countX][countY] = Math.max(LCSMemo(x, y, countX, countY-1, memo),
                    LCSMemo(x, y, countX-1, countY, memo));
        }
    }
}
