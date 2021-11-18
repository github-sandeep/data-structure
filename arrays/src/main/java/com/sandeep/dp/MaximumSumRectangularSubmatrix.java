package com.sandeep.dp;

public class MaximumSumRectangularSubmatrix {
    private static int top =0;
    private static int down =0;

    public int runKadane(int a[]) {
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
        top = start;
        down = end;
        return max;
    }

    public int maxSumRectangle(int arr[][]) {
        int rows = arr.length;
        int cols = arr[0].length;
        int T[] = new int[rows];

        int left =0;
        int right =0;
        int upper =0;
        int lower =0;

        int maxFinalSum = Integer.MIN_VALUE;
        for(int l = 0; l < cols; l++) {
            for(int  i=0; i < rows; i++) {
                T[i] =0;
            }

            for(int r = l; r < cols; r++) {
                for(int  i=0; i < rows; i++) {
                    T[i] = T[i] + arr[i][r];
                }
                int maxSum = runKadane(T);
                if(maxSum > maxFinalSum) {
                    maxFinalSum = maxSum;
                    left = l;
                    right =r;
                    upper = top;
                    lower = down;
                }
            }
        }
        System.out.println("upper and left index: " + upper + " , " + left);
        System.out.println("down and right index: " + lower + " , " + right);
        return maxFinalSum;
    }

    public static void main(String[] args)
    {
        int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 } };
        System.out.println(new MaximumSumRectangularSubmatrix().maxSumRectangle(arr));
    }
}
