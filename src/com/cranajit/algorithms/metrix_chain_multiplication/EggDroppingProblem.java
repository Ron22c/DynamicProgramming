package com.cranajit.algorithms.metrix_chain_multiplication;

public class EggDroppingProblem {
    private static int[][] memo;

    public static void main(String[] args) {
        int floor = 6;
        int eggs = 3;

        memo = new int[eggs+1][floor+1];
        for(int i = 0; i<eggs+1; i++) {
            for(int j = 0; j<floor+1; j++) {
                memo[i][j]=-1;
            }
        }

        System.out.println(eggDroppingProblem(eggs, floor));

    }

    public static int eggDroppingProblem(int e, int f) {
        if(f == 0 || f == 1) {
            return f;
        }

        if(e == 1) {
            return f;
        }

        if(memo[e][f] != -1) {
            System.out.println(memo[e][f]);
            return memo[e][f];
        }

        int result = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++) {
            int breakEgg = memo[e-1][k-1] =  eggDroppingProblem(e - 1, k - 1);
            int nonBreakEgg = memo[e][f-k] = eggDroppingProblem(e, f - k);
            int temp = 1 + Math.max(breakEgg, nonBreakEgg);
            result = Math.min(temp, result);
        }

        return memo[e][f] = result;
    }

}
