package com.sandeep.dp;

import com.sandeep.misc.KadaneAlgo;

public class MinJumps {
    public int jump(int[] nums, int res[]) {
        int n = nums.length;
        int T[] = new int[n];
        T[0] = 0;
        for(int i=1; i < n; i++) {
            T[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i < n ;i++) {
            for(int j=0; j <i; j++) {
                if(nums[j] >= i-j) {
                    if(T[i] > T[j] +1) {
                        T[i] = T[j] +1;
                        res[i] = j;
                    }
                }
            }
        }
        return T[n-1];
    }

    public static void main (String[] args)
    {
        int [] a = {2,3,1,1,4};
        int res[] = new int[a.length];
        System.out.println("Min jumo is " + new MinJumps().jump(a, res));
        int j = a.length-1;
        System.out.println("reverse jump index are: ");
        while(j >=0) {
            System.out.print(res[j] + " ");
            j = res[j];
            if(j==0)
                break;
        }
    }
}
