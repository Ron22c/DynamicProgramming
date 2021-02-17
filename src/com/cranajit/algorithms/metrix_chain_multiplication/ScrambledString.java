package com.cranajit.algorithms.metrix_chain_multiplication;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    static Map<String, Boolean> memo;
    public static void main(String[] args) {
        String a = "great";
        String b = "etagr";
        System.out.println(scrambledString(a, b));

        memo = new HashMap<>();
        System.out.println(scramString(a, b));
    }

    public static boolean scramString(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        if(a.equalsIgnoreCase("") && b.equalsIgnoreCase("")) {
            return true;
        }

        return scramStringRec(a, b);
    }

    private static boolean scramStringRec(String a, String b) {
        if(a.equalsIgnoreCase(b)) {
            return true;
        }

        if(a.length() <= 1 || b.length() <= 1) {
            return false;
        }

        if(memo.get(a+" "+b) != null) {
            return memo.get(a+" "+b);
        }

        boolean ans = false;
        for(int i = 1; i <= a.length()-1; i++) {
            boolean w = scramStringRec(a.substring(0, i), b.substring(b.length()-i));
            memo.put(a.substring(0, i)+" "+b.substring(b.length()-i), w);

            boolean x = scramStringRec(a.substring(i, a.length()), b.substring(0, b.length()-i));
            memo.put(a.substring(i, a.length()) +" "+ b.substring(0, b.length()-i), x);

            boolean y = scramStringRec(a.substring(0, i), b.substring(0, i));
            memo.put(a.substring(0, i) +" "+ b.substring(0, i), y);

            boolean z = scramStringRec(a.substring(i), b.substring(i));
            memo.put(a.substring(i) +" "+ b.substring(i), z);

            if((w && x)||(y && z)) {
                ans = true;
                break;
            }
        }
        memo.put(a+" "+b, ans);
        return ans;
    }

    public static boolean scrambledString(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        if(a.equalsIgnoreCase("") && b.equalsIgnoreCase("")) {
            return true;
        }
        return solveScrambledString(a, b);
    }

    public static boolean solveScrambledString(String a, String b) {
        if(a.equalsIgnoreCase(b)) {
            return true;
        }

        if(a.length() <= 1 || b.length() <= 1) {
            return false;
        }

        boolean isScrambled = false;

        for(int i = 1; i <= a.length()-1; i++) {
            boolean w = solveScrambledString(a.substring(0, i), b.substring(b.length() - i));
            boolean x = solveScrambledString(a.substring(i, a.length()), b.substring(0, b.length()-i));
            boolean y = solveScrambledString(a.substring(0, i), b.substring(0, i));
            boolean z = solveScrambledString(a.substring(i, a.length()), b.substring(i, b.length()));

            if((w && x) || (y && z)) {
                isScrambled = true;
                break;
            }
        }

        return isScrambled;
    }
}
