package com.sandeep.parkinglot.sorting;

/**
 * Worst Case Time Complexity [ Big-O ]: O(n*log n)
 * Best Case Time Complexity [Big-omega]: O(n*log n)
 * Average Time Complexity [Big-theta]: O(n*log n)
 * stable sort
 */
public class MergeSort {
   private static void merge(int arr[], int p, int q, int r) {
      int nl = q-p+1;
      int nr = r-q;
      int al[] = new int[nl];
      int ar[] = new int[nr];
      for(int i =0; i < nl ; i++) {
         al[i] = arr[p+i];
      }

      for(int j =0; j < nr ; j++) {
         ar[j] = arr[q+j+1];
      }
      int i =0;
      int j =0;
      int k = p;
      while(i < nl && j < nr) {
         if(al[i] <= ar[j] ) {
            arr[k] = al[i];
            i++;
         } else {
            arr[k] = ar[j];
            j++;
         }
         k++;
      }
     while(i < nl) {
        arr[k] = al[i];
        i++;
        k++;
     }

     while(j < nr) {
        arr[k] = ar[j];
        j++;
        k++;
     }
   }

   private static void mergeSort(int arr[], int p, int r) {
      if(p < r) {
         int q = (p+r)/2;
         mergeSort(arr, p, q);
         mergeSort(arr, q+1, r);
         merge(arr, p, q, r);
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
      mergeSort(arr, 0, arr.length-1);
      System.out.println();
      printArray(arr, arr.length);
   }
}
