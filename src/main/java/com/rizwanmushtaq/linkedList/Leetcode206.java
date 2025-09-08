package com.rizwanmushtaq.linkedList;

public class Leetcode206 {
  public ListNode reverseListIterativeApproach(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    return previous;
  }

  public ListNode reverseListRecursiveApproach(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = reverseListRecursiveApproach(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
