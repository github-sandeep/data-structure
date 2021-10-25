package com.sandeep.dp;

public class KnapSackBottomUp {
    public int getMaxKnapSackRecur (int val[], int wt[], int W, int n){
        if(n == 0 || W == 0) {
            return 0;
        }
        if(W < wt[n-1]) {
            return getMaxKnapSackRecur(val, wt, W, n-1);
        }
        return Math.max(getMaxKnapSackRecur(val, wt, W, n-1), val[n-1] + getMaxKnapSackRecur(val, wt, W-wt[n-1], n-1));
    }

    public int getMaxKnapSackBottomUp(int val[], int wt[], int W, int n) {
        int temp[][] = new int[n+1][W+1];
        for(int i = 0; i <= n ; i++) {
            for(int j =0; j <= W ; j++) {
                if( i == 0 || j == 0) {
                    temp[i][j] = 0;
                    continue;
                }
                if( j < wt[i-1]) {
                    temp[i][j] = temp[i-1][j];
                } else {
                    temp[i][j] = Math.max(temp[i-1][j], val[i-1] + temp[i-1][j-wt[i-1]]);
                }
            }
        }
        return temp[n][W];
    }

    public static void main(String args[]) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println(new KnapSackBottomUp().getMaxKnapSackRecur(val, wt, W, val.length));
        System.out.println(new KnapSackBottomUp().getMaxKnapSackBottomUp(val, wt, W, val.length));
    }
}
