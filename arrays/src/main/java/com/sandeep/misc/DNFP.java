package com.sandeep.misc;

/**
 * The Dutch national flag (DNF) problem is one of the most popular programming problems proposed by Edsger Dijkstra.
 * The flag of the Netherlands consists of three colors: white, red, and blue. The task is to randomly arrange balls of
 * white, red, and blue such that balls of the same color are placed together.
 */
public class DNFP {
   static void printArray(int arr[], int n) {
      for(int i =0; i <n ; i++) {
         System.out.print(arr[i] + " ");
      }
   }

   static void swap(int arr[], int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   static void doDNFP(int arr[], int n) {
      int low = 0;
      int mid = 0;
      int high = n-1;

      while(mid <= high) {
         if(arr[mid] == 0) {
            swap(arr, low, mid);
            low ++;
            mid ++;
         } else if(arr[mid] == 1) {
            mid++;
         } else {
            swap(arr, mid, high);
            high--;
         }
      }
   }

   public static void main(String args[]) {
      int arr[] = {0, 0, 1, 2, 0, 1, 2};
      System.out.print("array before DFNP : ");
      printArray(arr, arr.length);
      doDNFP(arr, arr.length);
      System.out.print("\narray after DFNP  : ");
      printArray(arr, arr.length);
   }
}
