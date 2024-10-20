package com.sandeep.multithreading;

public class ClassicProducerConsumer {
    public static void main(String args[]) {
        FixedSizeQueue fixedSizeQueue = new FixedSizeQueue(10);
        Thread producerThread = new Thread(new Producer(fixedSizeQueue), "producer thread");
        Thread consumerThread = new Thread(new Consumer(fixedSizeQueue), "consumer thread");
        producerThread.start();
        consumerThread.start();
    }
}
