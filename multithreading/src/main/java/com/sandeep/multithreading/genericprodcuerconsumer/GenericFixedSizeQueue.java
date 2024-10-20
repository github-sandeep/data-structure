package com.sandeep.multithreading.genericprodcuerconsumer;


import java.util.LinkedList;
import java.util.Queue;

public class GenericFixedSizeQueue<T> {
    private final int capacity;
    private final Queue<T> queue = new LinkedList<>();
    public GenericFixedSizeQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(T item) {
        while(queue.size() == capacity) {
            try {
                System.out.println("Queue is Full");
                wait();
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(item);
        System.out.println("item produced: " + item);
        notifyAll();
    }

    public synchronized T consume() {
        while(queue.isEmpty()) {
            try{
                System.out.println("Queue is Empty");
                wait();
            } catch(InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        T item = queue.poll();
        System.out.println("item consumed: " + item);
        notifyAll();
        return item;
    }
}
