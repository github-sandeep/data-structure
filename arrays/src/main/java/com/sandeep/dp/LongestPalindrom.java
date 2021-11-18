package com.sandeep.dp;

public class LongestPalindrom {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int T[][] = new int[n][n];
        for(int i =0; i < n ; i++) {
            T[i][i] =1;
        }
        for(int l=2; l <=n ;l++) {
            for(int i=0; i < n-l+1; i++) {
                int j= i+l-1;
                if(s.charAt(i) == s.charAt(j)) {
                    T[i][j] = 2 + T[i+1][j-1];
                } else {
                    T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
                }
            }
        }
        return T[0][n-1];
    }

    public static void main(String[] args) {
        String seq = "bbbab";
        System.out.printf("The length of the LPS is %d", new LongestPalindrom().longestPalindromeSubseq(seq));
    }
}
