package com.sandeep.dp;

public class EditDistance {
    public int editDist(String str1, String str2, int m, int n) {
        int T[][] = new int[m+1][n+1];
        for(int i =0; i <=m ; i++) {
            T[i][0] = i;
        }
        for(int j =0 ; j <=n ; j++) {
            T[0][j] =j;
        }
        for(int i = 1; i <=m ; i++) {
            for(int j = 1 ; j <=n ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1];
                } else {
                    T[i][j] = 1+ Math.min(T[i-1][j-1], Math.min(T[i-1][j], T[i][j-1]));
                }
            }
        }
        return T[m][n];
    }

    public int editDistRecur(String str1, String str2, int m, int n) {
        if(m == 0)
            return n;
        if(n ==0 )
            return m;
        if(str1.charAt(m-1) == str2.charAt(n-1)) {
            return editDistRecur(str1, str2, m-1, n-1);
        } else {
            return 1+ Math.min(editDistRecur(str1, str2, m, n-1), Math.min(editDistRecur(str1, str2, m-1, n),
                    editDistRecur(str1, str2, m-1, n-1)));
        }
    }

    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(new EditDistance().editDistRecur(str1, str2, str1.length(), str2.length()));
        System.out.println(new EditDistance().editDist(str1, str2, str1.length(), str2.length()));
    }
}
