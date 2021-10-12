package com.sandeep.parkinglot.misc;

import java.util.Arrays;

public class Test {
   public static void main(String args[]) {
      int arr[] = {0, 1,2,3,4,5,6};
      int arr1[] = Arrays.copyOfRange(arr, 1,4);
      System.out.println(arr1);
   }
}
