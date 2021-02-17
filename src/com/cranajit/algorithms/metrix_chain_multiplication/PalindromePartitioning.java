package com.cranajit.algorithms.metrix_chain_multiplication;

public class PalindromePartitioning {
    static int[][] memo;
    public static void main(String[] args) {
        String s = "nitik";
        System.out.println(isPalindrome(s, 0, s.length()-1));
        System.out.println(palindromepart(s, 0, s.length()-1));

        memo = new int[s.length()+1][s.length()+1];
        for(int a = 0; a < s.length()+1; a++) {
            for(int b = 0; b < s.length(); b++) {
                memo[a][b] = -1;
            }
        }

        System.out.println(isOptimisedPalindrome(s, 0, s.length()-1));
        System.out.println(ppmemo(s, 0, s.length()-1));
    }

    public static int ppmemo(String s, int i, int j) {
        int min = Integer.MAX_VALUE;

        if(i >= j) {
            return 0;
        }

        if(isOptimisedPalindrome(s, i, j)) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        for(int k = i; k <= j-1; k++) {
            int left;
            int right;

            if(memo[i][k] != -1) {
                left = memo[i][k];
            } else {
                left = ppmemo(s, i, k);
                memo[i][k] = left;
            }

            if(memo[k+1][j] != -1) {
                right = memo[k+1][j];
            } else {
                right = ppmemo(s, k+1, j);
                memo[k+1][j] = right;
            }

            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }

        return memo[i][j] = min;
    }

    private static boolean isOptimisedPalindrome(String s, int i, int j) {
        if(i > j) return true;
        if(i == j) return true;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int palindromepart(String s, int i, int j) {
        if(i >= j) {
            return 0;
        }

        if(isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++) {
            int temp = 1 + palindromepart(s, i, k) + palindromepart(s, k+1, j);
            min = Math.min(min, temp);
        }

        return min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
