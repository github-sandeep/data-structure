package com.sandeep.parkinglot.misc;

import java.util.Arrays;

public class MedianSortedArraySameSize {
   public static float getMedian(int arr[], int size) {
      if(size%2 == 0) {
         return (arr[size/2] + arr[size/2-1])/2;
      }
      return arr[size/2];
   }

   public static float median(int arr1[], int arr2[], int size) {
      if(size ==1) {
         return (arr1[0]+arr2[0])/2;
      }
      if(size == 2) {
         return (Math.max(arr1[0],arr2[0]) + Math.min(arr1[1],arr2[1]))/2;
      }

      float med1 = getMedian(arr1, size);
      float med2 = getMedian(arr2, size);

      if(med1 == med2) {
         return med1;
      }

      if(med1 > med2) {
         if(size%2 == 0) {
            int subArr1[] = Arrays.copyOfRange(arr1, 0, size/2);
            int subArr2[] = Arrays.copyOfRange(arr2, size/2, size);
            return median(subArr1,  subArr2, size/2);
         } else {
            int subArr1[] = Arrays.copyOfRange(arr1, 0, size/2+1);
            int subArr2[] = Arrays.copyOfRange(arr2, size/2, size);
            return median(subArr1, subArr2, size/2+1);
         }
      } else {
         if(size%2 == 0) {
            int subArr2[] = Arrays.copyOfRange(arr2, 0, size/2);
            int subArr1[] = Arrays.copyOfRange(arr1, size/2, size);
            return median(subArr1,  subArr2, size/2);
         } else {
            int subArr2[] = Arrays.copyOfRange(arr2, 0, size/2+1);
            int subArr1[] = Arrays.copyOfRange(arr1, size/2, size);
            return median(subArr1, subArr2, size/2+1);
         }
      }
   }

   public static void main(String args[]) {
      int arr1[] = {1,3,5,7};
      int arr2[] = {2,4,6,8};
      int size = arr1.length;
      float medianOfTwoArr = median(arr1, arr2, size);
      System.out.println( "Median of the two arrays is: " +  medianOfTwoArr);

   }
}
