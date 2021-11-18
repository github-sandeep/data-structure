package com.sandeep.dp;

public class LongestIncreasingSubsequence{
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int T[]= new int[n];
        for(int i =0; i < n;i++){
            T[i] =1;
        }
        for(int i = 1; i <n ;i++) {
            for(int j = 0; j <i ;j++) {
                if(nums[i] > nums[j] && T[i] < T[j]+1) {
                    T[i] = T[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0; i < n; i++) {
            if(T[i] > max) {
                max = T[i];
            }
        }
        return max;
    }

    public static void main(String args[])
    {
        int arr[] = { 10,9,2,5,3,7,101,18 };
        System.out.println("Length of lis is " + new LongestIncreasingSubsequence().lengthOfLIS(arr));
    }
}
