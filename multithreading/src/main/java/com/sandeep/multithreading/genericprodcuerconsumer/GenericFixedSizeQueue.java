package com.sandeep.multithreading.genericprodcuerconsumer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class GenericFixedSizeQueue<T> {
    private final int capacity;
    private final Queue<T> queue = new LinkedList<>();
    Semaphore emptySlots ;
    Semaphore filledSlots;
    Semaphore lock = new Semaphore(1); // binary semaphore
    public GenericFixedSizeQueue(int capacity) {
        this.capacity = capacity;
        this.emptySlots = new Semaphore(capacity); // number of empty slots available
        this.filledSlots = new Semaphore(0); // number of filled slots available
    }

    public void produce(T item) throws InterruptedException {
        emptySlots.acquire();
        lock.acquire();
        try {
            queue.add(item);
            System.out.println("item produced: " + item);
        } finally {
            lock.release();
            filledSlots.release();
        }
    }

    public T consume() throws InterruptedException {
        filledSlots.acquire();
        lock.acquire();
        T item = null;
        try {
            item = queue.poll();
            System.out.println("item consumed: " + item);
        } finally {
            lock.release();
            emptySlots.release();
        }
        return item;
    }
}
