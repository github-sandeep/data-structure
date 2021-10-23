package com.sandeep.sorting;

/**
 * Worst Case Time Complexity [ Big-O ]: O(n2)
 * Best Case Time Complexity [Big-omega]: O(n)
 * Average Time Complexity [Big-theta]: O(n2)
 */
public class InsertionSort {
   private static void insertionSort(int arr[], int n) {
      for(int j=1; j < n ; j++) {
         int key = arr[j];
         int i = j-1;
         while(i >= 0 && arr[i] > key) {
            arr[i+1] = arr[i];
            i--;
         }
         arr[i+1] = key;
      }
   }

   private static void printArray(int arr[], int n) {
      for(int i =0; i < n ; i++) {
         System.out.print(arr[i] + " ");
      }
   }

   public static void main(String args[]) {
      int arr[] = {10, 7, 8, 9, 1, 5};
      printArray(arr, arr.length);
      insertionSort(arr, arr.length);
      System.out.println();
      printArray(arr, arr.length);
   }
}
