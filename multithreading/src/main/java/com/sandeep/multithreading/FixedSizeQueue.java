package com.sandeep.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class FixedSizeQueue {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public FixedSizeQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) {
        while(queue.size() == capacity) {
           try {
               System.out.println("Queue is full" );
               wait();
           } catch(InterruptedException ie) {
               ie.printStackTrace();
           }
        }
        queue.add(item);
        System.out.println("Item produced: " + item);
        notifyAll();
    }

    public synchronized int consume() {
        while(queue.isEmpty()) {
            try {
                System.out.println("Queue is empty");
                wait();
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        int ret = queue.poll();
        System.out.println("Item consumed: " + ret);
        notifyAll();
        return ret;
    }
}
