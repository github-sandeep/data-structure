package com.sandeep.parkinglot.problem;

import com.sandeep.parkinglot.entity.LinkedListNode;
import com.sandeep.parkinglot.util.LinkedList;

public class AddTwoNumber {
    // Head of list is first digit of number
    public static LinkedListNode<Integer> addTwoNumber(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2, int carry) {
        if(l1 ==null && l2 == null) {
            return null;
        }
        int value = carry;
        if(l1 != null) {
            value = value + l1.getData();
        }

        if(l2 != null) {
            value = value + l2.getData();
        }

        carry = value/10;
        value = value % 10;
        LinkedListNode<Integer> result = new LinkedListNode(value);
        LinkedListNode<Integer> next = addTwoNumber(l1 == null ? null: l1.getNext(), l2 == null ? null: l2.getNext(), carry);
        result.setNext(next);
        return result;
    }

    public static void main(String args[]) {
        LinkedList<Integer> l1 = new LinkedList();
        l1.insert(new LinkedListNode<Integer>(5));
        l1.insert(new LinkedListNode<Integer>(1));
        l1.insert(new LinkedListNode<Integer>(3));
        System.out.println("First number is: ");
        l1.printList();

        LinkedList<Integer> l2 = new LinkedList();
        l2.insert(new LinkedListNode<Integer>(4));
        l2.insert(new LinkedListNode<Integer>(3));
        //l2.insert(new LinkedListNode<Integer>(2));
        System.out.println("\nSecond number is: ");
        l2.printList();

        System.out.println("\nAddition of two number is: ");
        LinkedListNode<Integer> result = addTwoNumber(l1.getHead(),l2.getHead(),0);
        while(result != null) {
            System.out.print(result.getData() + "  ");
            result = result.getNext();
        }
    }
}
