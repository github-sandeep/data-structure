package com.sandeep.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedList {

   public ListNode mergeKLists(ListNode[] lists) {

      boolean flag = true;
      for(int i =0; i < lists.length ; i++) {
         if(lists[i]!=null) {
            flag = false;
         }
      }

      if(lists.length == 0 || flag == true)
         return null;

      PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
         public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
         }
      });

      for(int i =0; i < lists.length; i++) {
         if(lists[i] == null) {
            continue;
         }
         minHeap.add(lists[i]);
      }

      ListNode head = null;
      ListNode curr = null;
      while (!minHeap.isEmpty()) {
         ListNode temp = minHeap.poll();
         if (head == null) {
            head = temp;
            curr = temp;
         } else {
            curr.next = temp;
            curr = temp;
         }
         temp = temp.next;
         if (temp != null) {
            minHeap.add(temp);
         }
      }

      return head;
   }

   public static void main(String args[]) {
      SortKSortedList obj = new SortKSortedList();
      ListNode list[] = {null, new ListNode(1, null)};
      ListNode head = obj.mergeKLists(list);
      while(head!=null) {
         System.out.print(head.val + " ");
         head = head .next;
      }
   }
}
