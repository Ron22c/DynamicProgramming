package com.cranajit.algorithms.metrix_chain_multiplication;

public class MCM {
    static int[][]memo;
    public static void main(String[] args) {
        int[] arr = new int[]{10,30,40,50,30,40,50};

        System.out.println(mcm(arr, 1, arr.length-1));
        System.out.println(mcmp2(arr, 1, arr.length-1));

        memo = new int[arr.length+1][arr.length+1];
        for(int a = 0; a < arr.length+1; a++) {
            for(int b = 0; b < arr.length+1; b++) {
                memo[a][b] = -1;
            }
        }

        System.out.println(mcmMemo(arr, 1, arr.length-1));
    }

    public static int mcm(int[] arr, int i, int j) {
        if(i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++) {
            int temp = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min, temp);
        }

        return min;
    }

    public static int mcmp2(int[] arr, int i, int j) {
        if(i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = i+1; k <= j; k++) {
            int temp = mcmp2(arr, i, k-1) + mcmp2(arr, k, j) + arr[i-1]*arr[k-1]*arr[j];
            min = Math.min(min, temp);
        }

        return min;
    }

    public static int mcmMemo(int[] arr, int i, int j) {
        if(i >= j) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j-1; k++) {
            int temp = mcmMemo(arr, i, k) + mcmMemo(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min, temp);
        }

        return memo[i][j] = min;
    }
}
