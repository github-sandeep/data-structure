package com.sandeep.dp;

public class KnapsackTopDown {
   private static int knapsackRecur(int val[], int wt[], int W, int index, int n) {
      if(index >= n)
         return 0;
      if(wt[index] > W)
         return knapsackRecur(val, wt, W,index+1, n);
      return Math.max(val[index] + knapsackRecur(val, wt, W- wt[index], index+1, n),
                      knapsackRecur(val, wt, W,index+1, n));
   }

   private static int knapsackDp(int val[], int wt[], int W, int index, int n, Integer temp[][]) {
      if(index >= n) {
         temp[W][index] = 0;
         return temp[W][index];
      }
      if(wt[index] > W) {
         if (temp[W][index + 1] == null) {
            temp[W][index + 1] = knapsackDp(val, wt, W, index + 1, n, temp);
         }
         return temp[W][index + 1];
      }

      if(temp[W][index+1] == null) {
         temp[W][index+1] = knapsackDp(val, wt, W,index+1, n, temp);
      }
      if(temp[W-wt[index]][index+1] == null) {
         temp[W-wt[index]][index+1] =  knapsackDp(val, wt, W- wt[index], index+1, n, temp);
      }
      return Math.max(temp[W][index+1], val[index] + temp[W-wt[index]][index+1]);
   }

   public static void main(String[] args) {
      int val1[] = {10, 40, 30, 50};
      int wt1[] = {5, 4, 6, 3};
      int W1 = 10;
      System.out.println(knapsackRecur(val1, wt1, W1, 0, val1.length));

      /*int val2[] = new int[] { 60, 100, 120 };
      int wt2[] = new int[] { 10, 20, 30 };
      int W2 = 50;

      System.out.println(knapsackRecur(val2, wt2, W2, 0, val2.length));*/

      Integer temp1[][] = new Integer[W1+1][val1.length+1];
      for(int i =0; i <= W1 ;i++) {
         for(int j = 0; j <= val1.length ; j++) {
            temp1[i][j] = null;
         }
      }
      System.out.println(knapsackDp(val1, wt1, W1, 0, val1.length, temp1));

      /*Integer temp2[][] = new Integer[W2+1][val2.length+1];
      for(int i =0; i <= W2 ;i++) {
         for(int j = 0; j <= val2.length ; j++) {
            temp2[i][j] = null;
         }
      }
      System.out.println(knapsackDp(val2, wt2, W2, 0, val2.length, temp2));*/
   }
}
