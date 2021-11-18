package com.sandeep.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        boolean T[][] = new boolean[n][n];
        int start = 0;
        int len = 1;

        for(int i =0; i < n ; i++) {
            T[i][i] =true;
        }
        for(int i=0; i < n-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                T[i][i+1] = true;
                len =2;
                start = i;
            }
        }

        for(int l=3; l <=n ;l++) {
            for(int i=0; i < n-l+1; i++) {
                int j= i+l-1;
                if(s.charAt(i) == s.charAt(j) && T[i+1][j-1]) {
                    T[i][j] = true;
                    if(len < j-i+1) {
                        len = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+len);
    }

    public static void main(String[] args)
    {
        String str = "babad";
        System.out.println("longest palindrom substring is: " + new LongestPalindromicSubstring().longestPalindrome(str));
    }
}
