package com.sandeep.multithreading;

public class PrintEvenOdd {
    private final int max = 100;
    private int counter = 1;

    public void printEven() {
        synchronized (this) {
            while(counter <  max ) {
                if(counter % 2 == 1){
                    try {
                        this.wait();
                    } catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                this.notify();
            }
        }
    }

    public void printOdd() {
        synchronized (this) {
            while(counter < max) {
                if(counter % 2 == 0) {
                    try {
                        this.wait();
                    } catch(InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                this.notify();
            }
        }
    }

   public static void main(String args[]) {
       PrintEvenOdd evenodd =  new PrintEvenOdd();
       Thread odd = new Thread(new Runnable() {
           @Override
           public void run() {
               evenodd.printOdd();
           }
       }, "OddThread");

       Thread even = new Thread(new Runnable() {
           @Override
           public void run() {
               evenodd.printEven();
           }
       }, "EvenThread");

       odd.start();
       even.start();
   }
}
