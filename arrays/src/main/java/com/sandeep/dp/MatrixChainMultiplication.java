package com.sandeep.dp;

public class MatrixChainMultiplication {
    public void printSolution(int s[][], int i , int j) {
        if(i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printSolution(s, i, s[i][j]);
            printSolution(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }

    public int matrixChainOrder(int p[]) {
        int n = p.length-1;
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];
        for(int i =0; i < n ; i++) {
            m[i][i] = 0;
        }

        for(int l= 2; l <=n ; l++) {
            int iBound = n-l+1;
            for(int i = 0; i < iBound ; i++) {
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    int q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1];
                    if(q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        printSolution(s, 0 , 5);
        System.out.println();
        return m[0][n-1];
    }

    public static void main(String args[]) {
        int p[] = {30, 35, 15, 5, 10, 20, 25};
        System.out.println(new MatrixChainMultiplication().matrixChainOrder(p));
    }
}
