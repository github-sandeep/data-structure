package com.sandeep.misc;

public class KadaneAlgo {
    public int maxSubArraySum(int a[]) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int currStartIndex  =0;
        int start =0;
        int end =0;
        int maxIncludingCurr = 0;
        for(int  i=0; i < n ; i++ ) {
            maxIncludingCurr = maxIncludingCurr + a[i];
            if(max < maxIncludingCurr) {
                max = maxIncludingCurr;
                end = i;
                start = currStartIndex;
            }

            if(maxIncludingCurr < 0) {
                maxIncludingCurr =0;
                currStartIndex = i+1;
            }
        }
        System.out.println("start index: " + start + " and end index: " + end);
        return max;
    }

    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + new KadaneAlgo().maxSubArraySum(a));
    }
}
