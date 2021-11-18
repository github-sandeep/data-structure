package com.sandeep.dp;

public class OptimalBST {
    public int getSum(int freq[], int i , int j) {
        int sum  =0;
        for(int k=i; k <=j; k++) {
            sum+= freq[k];
        }
        return sum;
    }
    public int optimalSearchTree(int keys[], int freq[], int n) {
        int T[][] = new int[n][n];
        for(int  i=0; i < n ;i++) {
            T[i][i] = freq[i];
        }

        for(int l=2; l <=n; l++) {
            for(int i=0; i < n-l+1; i++) {
                int j = i+l-1;
                T[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i ,j);
                for(int k=i; k <=j ;k++) {
                    int val = sum + (k-1 < 0 ? 0:T[i][k-1]) + (k+1>j?0:T[k+1][j]);
                    if(val < T[i][j]) {
                        T[i][j] = val;
                    }
                }
            }
        }
        return T[0][n-1];
    }

    public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " + new OptimalBST().optimalSearchTree(keys, freq, n));
    }
}
