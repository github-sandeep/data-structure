package com.sandeep.multithreading;

public class Consumer implements Runnable {
    private FixedSizeQueue fixedSizeQueue;

    public Consumer(FixedSizeQueue fixedSizeQueue) {
        this.fixedSizeQueue = fixedSizeQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                fixedSizeQueue.consume();
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
