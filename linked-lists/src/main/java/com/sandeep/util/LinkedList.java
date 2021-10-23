package com.sandeep.util;

import com.sandeep.entity.LinkedListNode;

public class LinkedList<T> {
    private LinkedListNode<T> head = null;

    public LinkedListNode<T> insert(LinkedListNode<T> node) {
        if(head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        return head;
    }

    public LinkedListNode<T> remove() {
        if(head != null) {
            if(head.getNext() != null) {
                head = head.getNext();
            } else {
                head = null;
            }
        }
        return head;
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    public void printList() {
        LinkedListNode<T> curr = head;
        while(curr != null) {
            System.out.print(curr.getData() + "  ");
            curr = curr.getNext();
        }
    }
}
