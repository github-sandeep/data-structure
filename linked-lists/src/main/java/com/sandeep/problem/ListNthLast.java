package com.sandeep.problem;

import com.sandeep.entity.LinkedListNode;
import com.sandeep.util.LinkedList;

public class ListNthLast {
    // Assuming list size >= n
    public static LinkedListNode<Integer> getNthLast(LinkedListNode head , int n) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        while(p2 != null && n > 1) {
            p2 = p2.getNext();
            n = n-1;
        }

        while(p2!= null && p2.getNext() != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }
        return p1;
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList();
        list.insert(new LinkedListNode<Integer>(2));
        list.insert(new LinkedListNode<Integer>(3));
        list.insert(new LinkedListNode<Integer>(4));
        list.insert(new LinkedListNode<Integer>(5));
        // list.insert(new LinkedListNode<Integer>(6));
        //list.insert(new LinkedListNode<Integer>(7));

        System.out.println("List elements are: ");
        list.printList();
        System.out.println("\nNth Last element is : " + getNthLast(list.getHead(), 4).getData());
    }
}
