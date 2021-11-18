package com.sandeep.misc;

import java.util.HashMap;
import java.util.Map;

class CacheNode<T>{
    T key;
    T value;
    CacheNode<T> next;
    CacheNode<T> prev;
    public CacheNode(T key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class LRU<T> {
    int capacity = 5;
    Map<T, CacheNode> cacheMap;
    CacheNode head;
    CacheNode tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        cacheMap  = new HashMap<>();
    }

    public void removeTailAndMapNode() {
        cacheMap.remove(tail.key);
        if(tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    public void updateHead(CacheNode keyNode) {
        if(keyNode == head)
            return;

        if(head == null) {
            head = keyNode;
            tail = keyNode;
        } else {
            if(keyNode == tail) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                if(keyNode.prev!= null && keyNode.next!= null) { // update existing node when capacity is not reached
                    keyNode.next.prev = keyNode.prev;
                    keyNode.prev.next = keyNode.next;
                }
            }
            keyNode.next = head;
            head.prev = keyNode;
            head = keyNode;
        }
    }

    public <T> T get(T key) {
        CacheNode keyNode = cacheMap.get(key);
        if(keyNode != null) {
            updateHead(keyNode);
            return (T) keyNode.value;
        }
        return (T) new Integer(-1);
    }

    public void put(T key, T value) {
        if(cacheMap.containsKey(key)) {
            CacheNode keyNode = cacheMap.get(key);
            keyNode.value = value;
            updateHead(keyNode);
        } else {
            if(cacheMap.size() >= capacity) {
                removeTailAndMapNode();
                CacheNode keyNode = new CacheNode(key, value);
                updateHead(keyNode);
                cacheMap.put(key, keyNode);
            } else {
                CacheNode keyNode = new CacheNode(key, value);
                updateHead(keyNode);
                cacheMap.put(key, keyNode);
            }
        }
    }

    public static void main(String args[]) {
        LRU obj = new LRU(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
