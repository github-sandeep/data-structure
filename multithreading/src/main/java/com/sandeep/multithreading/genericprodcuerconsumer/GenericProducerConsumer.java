package com.sandeep.multithreading.genericprodcuerconsumer;

public class GenericProducerConsumer {
    public static void main(String args[]) {
        String[] items = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        GenericFixedSizeQueue<String> queue = new GenericFixedSizeQueue<>(10);
        Thread producer = new Thread(new GenericProducer<String>(queue, items), "producer thread");
        Thread consumer = new Thread(new GenericConsumer<String>(queue), "consumer thread");
        producer.start();
        consumer.start();
    }
}
