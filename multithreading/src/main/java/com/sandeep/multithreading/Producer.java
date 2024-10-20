package com.sandeep.multithreading;

public class Producer implements Runnable {
    private FixedSizeQueue fixedSizeQueue;
    public Producer(FixedSizeQueue fixedSizeQueue) {
        this.fixedSizeQueue = fixedSizeQueue;
    }
    @Override
    public void run() {
        int i = 0;
        while(true) {
            fixedSizeQueue.produce(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
