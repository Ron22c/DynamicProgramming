package com.cranajit.algorithms.metrix_chain_multiplication;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesization {

    private static Map<String, Integer> memo;

    public static void main(String[] args) {
        String s = "t^f&t&t";
        System.out.println(booleanParenthesization(s, 0, s.length()-1, true));

        memo = new HashMap<>();
        System.out.println(boolPar(s, 0, s.length()-1, true));
        System.out.println(bpar(s, 0, s.length()-1, true));

    }


    public static int bpar(String s, int i, int j, boolean isTrue) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            if(isTrue) {
                return s.charAt(i) == 't' ? 1 : 0;
            } else {
                return s.charAt(i) == 'f' ? 1 : 0;
            }
        }

        int result = 0;

        for(int k = i+1; k <= j-1; k = k+2) {
            int leftTrue = bpar(s, i, k-1, true);
            int rightTrue = bpar(s, k+1, j, true);
            int leftFalse = bpar(s, i, k-1, false);
            int rightFalse = bpar(s, k+1, j, false);

            if(s.charAt(k) == '&') {
                if(isTrue) result = result + leftTrue * rightTrue;
                else result = result + leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse;
            } else if(s.charAt(k) == '|') {
                if(isTrue) result = result + rightTrue * leftTrue;
                else result = result + rightTrue * leftFalse + rightFalse * leftTrue + rightFalse * leftFalse;
            } else if(s.charAt(k) == '^') {
                if(isTrue) result = result + rightTrue * leftFalse + rightFalse * leftTrue;
                else result = result + rightTrue * leftTrue + rightFalse * leftFalse;
            }
        }

        return result;
    }


    public static int boolPar(String s, int i, int j, boolean isTrue) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            if(isTrue) {
                return s.charAt(i) == 't' ? 1 : 0;
            } else {
                return s.charAt(i) == 'f' ? 1 : 0;
            }
        }

        if(memo.get(""+i+j+isTrue) != null) {
            return memo.get(""+i+j+isTrue);
        }

        int result = 0;

        for(int k = i+1; k <= j-1; k = k+2) {
            int leftTrue = boolPar(s, i, k-1, true);
            memo.put(""+i+(k-1)+true, leftTrue);

            int leftFalse = boolPar(s, i, k-1, false);
            memo.put(""+i+(k-1)+false, leftFalse);

            int rightTrue = boolPar(s, k+1, j, true);
            memo.put(""+(k+1)+j+true, rightTrue);

            int rightFalse = boolPar(s, k+1, j, false);
            memo.put(""+(k+1)+j+false, rightFalse);

            if(s.charAt(k) == '&') {
                if(isTrue) result = result + rightTrue * leftTrue;
                else result = result + rightTrue * leftFalse + rightFalse * leftTrue + leftFalse * rightFalse;
            } else if(s.charAt(k) == '|') {
                if(isTrue) result = result + rightTrue * leftTrue + rightTrue * leftFalse + rightFalse * leftTrue;
                else result = result + rightFalse * leftFalse;
            } else if(s.charAt(k) == '^') {
                if(isTrue) result = result + rightTrue * leftFalse + rightFalse * leftTrue;
                else result = result + rightTrue * leftTrue + rightFalse * leftFalse;
            }
        }

        memo.put(""+i+j+isTrue, result);

        return result;
    }

    public static int booleanParenthesization(String s, int i, int j, boolean isTrue) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            if(isTrue) {
                return s.charAt(i) == 't' ? 1 : 0;
            } else {
                return s.charAt(i) == 'f' ? 1 : 0;
            }
        }

        int answer = 0;

        for(int k = i+1; k <= j-1; k = k+2) {
            int leftTrue = booleanParenthesization(s, i, k-1, true);
            int leftFalse = booleanParenthesization(s, i, k-1, false);
            int rightTrue = booleanParenthesization(s, k+1, j, true);
            int rightFalse = booleanParenthesization(s, k+1, j, false);

            if(s.charAt(k) == '&') {
                if(isTrue) {
                    answer = answer + leftTrue * rightTrue;
                } else {
                    answer = answer + leftFalse * rightFalse + leftTrue * rightFalse + rightTrue * leftFalse;
                }
            } else if(s.charAt(k) == '|') {
                if(isTrue) {
                    answer = answer + leftTrue * rightTrue + leftTrue * rightFalse + rightTrue * leftFalse;
                } else {
                    answer = answer + leftFalse * rightFalse;
                }
            } else if(s.charAt(k) == '^') {
                if(isTrue) {
                    answer = answer + leftFalse * rightTrue + leftTrue * rightFalse;
                } else {
                    answer = answer + leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }

        return answer;
    }


}
