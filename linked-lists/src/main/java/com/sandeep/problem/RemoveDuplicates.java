package com.sandeep.problem;

import com.sandeep.entity.LinkedListNode;
import com.sandeep.util.LinkedList;

import java.util.Hashtable;

public class RemoveDuplicates {
    public static void removeDuplicate(LinkedListNode<Integer> head) {
        Hashtable<Integer, Boolean> set = new Hashtable();
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = head;
        while(curr != null) {
            if(set.containsKey(curr.getData())) {
                prev.setNext(curr.getNext());
            } else {
                set.put(curr.getData(), true);
                prev = curr;
            }
            curr = curr.getNext();
        }
    }

    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList();
        list.insert(new LinkedListNode<Integer>(2));
        list.insert(new LinkedListNode<Integer>(3));
        list.insert(new LinkedListNode<Integer>(2));
        list.insert(new LinkedListNode<Integer>(4));
        list.insert(new LinkedListNode<Integer>(5));
        list.insert(new LinkedListNode<Integer>(3));
        list.insert(new LinkedListNode<Integer>(5));
        System.out.println("List before duplicate removal: ");
        list.printList();
        removeDuplicate(list.getHead());
        System.out.println("\nList after duplicate removal: ");
        list.printList();

        /*LinkedList<Integer> list = new LinkedList();
        list.insert(new LinkedListNode<Integer>(2));
        list.insert(new LinkedListNode<Integer>(2));
        list.insert(new LinkedListNode<Integer>(2));
        System.out.println("List before duplicate removal: ");
        list.printList();
        removeDuplicate(list.getHead());
        System.out.println("\nList after duplicate removal: ");
        list.printList();*/
    }
}
