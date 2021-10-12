package com.sandeep.parkinglot.util;

class PrimeNumber {

   static boolean isPrime(long n)
   {

      // Check if number is less than
      // equal to 1
      if (n <= 1)
         return false;

         // Check if number is 2
      else if (n == 2)
         return true;

         // Check if n is a multiple of 2
      else if (n % 2 == 0)
         return false;

      // If not, then just check the odds
      for (long i = 3; i <= Math.sqrt(n); i += 2)
      {
         if (n % i == 0)
            return false;
      }
      return true;
   }

   public static void main(String[] args)
   {
      long start = System.nanoTime();
      if (isPrime(23003133223576l))
         System.out.println("this is prime ");

      else
         System.out.println("this is not prime");
      long end = System.nanoTime();
      System.out.println("time taken to run this code is  " + (end-start));
   }
}
