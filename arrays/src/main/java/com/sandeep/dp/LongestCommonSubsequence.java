package com.sandeep.dp;

public class LongestCommonSubsequence {
    public int getLongestCommonSubsequenceBottomUp(String s1, String s2, int n1, int n2) {
        int temp[][] = new int[n1+1][n2+1];
        for(int i =0; i <= n1; i++) {
           for(int j =0; j <= n2 ; j++) {
                if(i == 0 || j == 0) {
                    temp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
                }
           }
        }
        return temp[n1][n2];
    }

    public int getLongestCommonSubsequenceRecur(String s1, String s2, int i, int j, int n1, int n2) {
        if(i == n1 || j == n2) {
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + getLongestCommonSubsequenceRecur(s1, s2, i+1, j+1, n1, n2);
        }

        return Math.max(getLongestCommonSubsequenceRecur(s1, s2, i+1, j, n1, n2),
                getLongestCommonSubsequenceRecur(s1, s2, i, j+1, n1, n2));
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(new LongestCommonSubsequence().getLongestCommonSubsequenceRecur(s1, s2, 0, 0, s1.length(), s2.length()));
        System.out.println(new LongestCommonSubsequence().getLongestCommonSubsequenceBottomUp(s1, s2, s1.length(), s2.length()));
    }
}
