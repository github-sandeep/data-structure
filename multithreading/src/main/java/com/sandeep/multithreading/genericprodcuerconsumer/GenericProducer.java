package com.sandeep.multithreading.genericprodcuerconsumer;

import static java.lang.Thread.sleep;

public class GenericProducer<T> implements Runnable{
    private final GenericFixedSizeQueue<T> queue;
    private final T[] items;
    public GenericProducer(GenericFixedSizeQueue<T> queue, T[] items) {
        this.queue = queue;
        this.items = items;
    }

    @Override
    public void run() {
        for(T item : items) {
            try {
                queue.produce(item);
                sleep(500);
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
