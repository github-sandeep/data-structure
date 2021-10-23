package com.sandeep.misc;

public class MedianSortedArrayDiffSize {
   public static double median(int[] nums1, int[] nums2, int x, int y) {
      if(x > y) {
         return median(nums2, nums1, y, x);
      }

      int low = 0;
      int high = x;
      while(low <= high) {
         int partitionX = (low+high)/2;
         int partitionY = (x+y+1)/2 - partitionX;

         int nums1LeftMax = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
         int nums1RightMin = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
         int nums2LeftMax = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
         int nums2RightMin = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

         if(nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
            if((x+y)%2 == 0) {
               return (float)(Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))/2;
            }
            else {
               return Math.max(nums1LeftMax, nums2LeftMax);
            }
         }
         else if(nums1LeftMax > nums2RightMin) {
            high = partitionX-1;
         } else {
            low = partitionX+1;
         }
      }
      return -1;
   }

   public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      return median(nums1, nums2, nums1.length, nums2.length);
   }

   public static void main(String args[]) {
      int nums1[] = {1,2};
      int nums2[] = {3,4};
      System.out.println(findMedianSortedArrays(nums1, nums2));
   }
}
