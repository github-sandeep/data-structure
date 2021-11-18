package com.sandeep.dp;

public class AssemblyLineSchedule {
    public void printStations(int l[][], int n, int lFinal) {
        int i = lFinal;
        System.out.println("line  " + i + "  station  " + n);
        for(int j=n-1 ; j >0 ; j--) {
            i = l[i][j];
            System.out.println("line  " + i + "  station  " + j);
        }
    }

    public void fastest(int a[][], int t[][], int e[], int x[])  {
        int n = a[0].length;
        int f[][] = new int[2][n];
        int l[][] = new int[2][n];
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];
        for(int j = 1; j < n; j++) {
            if(f[0][j-1] + a[0][j] <= f[1][j-1] + t[1][j-1] + a[0][j]) {
                f[0][j] = f[0][j-1] + a[0][j];
                l[0][j] = 0;
            } else {
                f[0][j] = f[1][j-1] + t[1][j-1] + a[0][j];
                l[0][j] = 1;
            }

            if(f[1][j-1] + a[1][j] <= f[0][j-1] + t[0][j-1] + a[1][j]) {
                f[1][j] = f[1][j-1] + a[1][j];
                l[1][j] = 1;
            } else {
                f[1][j] = f[0][j-1] + t[0][j-1] + a[1][j];
                l[1][j] = 0;
            }
        }
        int fCost = 0;
        int lFinal = -1;
        if(f[0][n-1] + x[0] <= f[1][n-1] + x[1]) {
            fCost = f[0][n-1] + x[0];
            lFinal = 0;
        } else {
            fCost = f[1][n-1] + x[1];
            lFinal = 1;
        }
        System.out.println("fastest cost is : " + fCost);
        printStations(l, n, lFinal);
    }

    public static void main(String args[]) {
        int a[][] = {{7,9,3,4,8,4}, {8,5,6,4,5,7}};
        int t[][] = {{2,3,1,3,4}, {2,1,2,2,1}};
        int e[] = {2,4};
        int x[] = {3,2};
        new AssemblyLineSchedule().fastest(a,t,e,x);
    }
}
