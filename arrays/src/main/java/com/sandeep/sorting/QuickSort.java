package com.sandeep.sorting;


public class QuickSort {
   public static void quickSort(int arr[], int low, int high) {
      if(low < high) {
         int pivot = partition(arr, low, high);
         quickSort(arr, low, pivot - 1);
         quickSort(arr, pivot + 1, high);
      }
   }

   public static void swap(int arr[], int i , int j) {
      int temp = arr[i];
      arr[i]= arr[j];
      arr[j]= temp;
   }

   public static int partition(int arr[], int low, int high) {
      int i = low-1;
      int pivot = arr[high];
      for(int j = low; j < high; j++) {
         if(arr[j] <= pivot) {
            i++;
            swap(arr, i , j);
         }
      }
      swap(arr, i+1, high);
      return i+1;
   }

   public static void printArray(int arr[], int n) {
      for(int i =0; i < n ; i++) {
         System.out.print(arr[i] + " ");
      }
   }

   public static void main(String args[]) {
      int arr[] = {10, 7, 8, 9, 1, 5};
      printArray(arr, arr.length);
      quickSort(arr, 0, arr.length-1);
      System.out.println();
      printArray(arr, arr.length);
   }
}
