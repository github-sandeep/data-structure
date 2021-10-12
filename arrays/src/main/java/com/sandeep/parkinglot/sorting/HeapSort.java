package com.sandeep.parkinglot.sorting;

/**
 * in-place algorithm
 * not stable
 * Time complexity of heapify is O(Logn)
 * Time complexity of createAndBuildHeap() is O(n) and the overall time complexity of Heap Sort is O(nLogn)
 */
public class HeapSort {
   private static void heapify(int arr[], int n, int i) {
      int smallest = i;
      int left = 2*i+1;
      int right = 2*i+2;
      if(left< n && arr[smallest] > arr[left]) {
         smallest = left;
      } else if(right < n && arr[smallest] > arr[right]) {
         smallest = right;
      }
      if(i!=smallest) {
         int temp = arr[i];
         arr[i] = arr[smallest];
         arr[smallest] = temp;
         heapify(arr, n, smallest);
      }
   }

   private static void buildHeap(int arr[], int n) {
      int k = n/2-1;
      for(int i = k; i >=0 ;i--) {
         heapify(arr, n, i);
      }
   }

   private static void heapSort(int arr[], int n) {
      buildHeap(arr,n);
      for(int j = n-1; j > 0; j--) {
         int temp = arr[j];
         arr[j] = arr[0];
         arr[0] = temp;
         heapify(arr, j, 0);
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
      heapSort(arr, arr.length);
      System.out.println();
      printArray(arr, arr.length);
   }
}
