package com.sandeep.dp;

public class EggDrop {
    public int eggDrop(int  n, int k) {
        int T[][] = new int[n+1][k+1];
        for(int j =0; j <= k ; j++) {
            T[1][j] = j;
        }

        for(int i =2; i <=n ; i++) {
            for(int j=1; j <=k; j++) {
                T[i][j]= Integer.MAX_VALUE;
                for(int m =1; m <=j ; m++) {
                    int val = 1+ Math.max(T[i-1][m-1], T[i][j-m]);
                    if(T[i][j] > val)
                        T[i][j] = val;
                }
            }
        }
        return T[n][k];
    }

    public int eggDropRecur(int n, int k) {
        if(n == 1)
            return k;
        if(k == 0)
            return 0;
        int res =Integer.MAX_VALUE;
        for(int i=1; i <= k ;i++) {
            int min = 1 + Math.max(eggDropRecur(n-1, i-1), eggDropRecur(n, k-i));
            if(min < res)
                res = min;
        }
        return res;
    }

    public static void main(String args[])
    {
        int n = 2, k = 10; // n egg and k floor
        System.out.println("Minimum number of trials in worst " + new EggDrop().eggDropRecur(n, k));
        System.out.println("Minimum number of trials in worst " + new EggDrop().eggDrop(n, k));
    }
}
