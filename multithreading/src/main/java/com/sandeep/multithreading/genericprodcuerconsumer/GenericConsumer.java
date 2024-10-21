package com.sandeep.multithreading.genericprodcuerconsumer;

import static java.lang.Thread.sleep;

public class GenericConsumer<T> implements Runnable{
    private final GenericFixedSizeQueue<T> queue;

    public  GenericConsumer(GenericFixedSizeQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                T item = queue.consume();
                sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
