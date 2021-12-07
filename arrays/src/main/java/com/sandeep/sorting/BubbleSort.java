package com.sandeep.sorting;

/**
 * best case: already sorted, complexity O(N)
 * Worst case: O(N^2)
 * stable as two objects with equal keys appear in the same order
 * an inplace algorithm as if it does not need an extra space and produces an output in the same memory
 * advantage: ability to detect whether the list is sorted efficiently
 * disadvantage: Bubble sort is slower than the other O(n2) sorting algorithms
 */
public class BubbleSort {
   private static void bubbleSort(int arr[], int n) {
      for(int i = 0; i < n ; i++) {
         boolean swap = false;
         for(int j = n-2; j >=0; j--) {
            if(arr[j] > arr[j+1]) {
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
               swap = true;
            }
         }
         if(!swap) {
            break;
         }
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
      bubbleSort(arr, arr.length);
      System.out.println();
      printArray(arr, arr.length);
   }
}
