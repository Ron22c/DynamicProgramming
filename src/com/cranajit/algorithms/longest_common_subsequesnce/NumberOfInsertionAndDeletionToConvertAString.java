package com.cranajit.algorithms.longest_common_subsequesnce;

import java.util.HashMap;
import java.util.Map;

public class NumberOfInsertionAndDeletionToConvertAString {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";

        NIDSC(x, y).entrySet().stream().forEach(entry-> {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        });
    }

    public static Map<String, Integer> NIDSC (String x, String y) {
        Map<String, Integer> result = new HashMap<>();
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
        result.put("insertion", y.length() - dp[x.length()][y.length()]);
        result.put("deletion", x.length() - dp[x.length()][y.length()]);

        return result;
    }
}
