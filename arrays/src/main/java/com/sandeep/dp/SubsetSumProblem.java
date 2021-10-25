package com.sandeep.dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblem {
    public void printElements(int set[], boolean temp[][], int sum) {
        int i = temp.length-1;
        int j = temp[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(i > 0 && j > 0) {
            if(j == 0) {
                break;
            }
            if(temp[i][j]) {
                i = i-1;
            } else {
                ans.add(set[i]);
                j = j - set[i];
            }
        }
        for(int k: ans) {
            System.out.print(k + " ");
        }
    }

    public boolean hasSubSetBottomUp(int set[], int sum, int n) {
        boolean temp[][] = new boolean[n+1][sum+1];
        for(int i =0; i <= n ; i++) {
            for(int j =0; j <= sum ; j++) {
                if( j == 0) {
                    temp[i][j] = true; // if sum is zero
                    continue;
                }
                if(i == 0) {
                    temp[i][j] = false; // if set is empty
                    continue;
                }
                if(set[i-1] > j) {
                    temp[i][j] = temp[i-1][j];
                } else {
                    temp[i][j] = temp[i-1][j] || temp[i-1][j-set[i-1]];
                }
            }
        }
        if(temp[n][sum]) {
            printElements(set, temp, sum);
            System.out.println();
        }
        return temp[n][sum];
    }

    public boolean hasSubSetRecur(int set[], int sum, int n) {
        if( sum == 0) {
            return true;
        }
        if( n == 0) {
            return false;
        }
        if(set[n-1] <= sum) {
            return hasSubSetRecur(set, sum - set[n-1], n-1) || hasSubSetRecur(set, sum, n-1);
        } else {
            return hasSubSetRecur(set, sum, n-1 );
        }
    }

    public static void main(String args[]) {
        /*int set[] = { 2,3,7,8,10 };
        int sum = 11;*/
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        System.out.println(new SubsetSumProblem().hasSubSetRecur(set, sum ,n));
        System.out.println(new SubsetSumProblem().hasSubSetBottomUp(set, sum ,n));
    }
}
