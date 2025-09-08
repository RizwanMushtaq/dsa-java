package com.rizwanmushtaq.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Leetcode206Test {
  private Leetcode206 solver;

  @BeforeEach
  void setup() {
    solver = new Leetcode206();
  }

  // Helper: build linked list from array
  private Leetcode206.ListNode buildList(int[] values) {
    Leetcode206.ListNode dummy = solver.new ListNode(0);
    Leetcode206.ListNode current = dummy;
    for (int val : values) {
      current.next = solver.new ListNode(val);
      current = current.next;
    }
    return dummy.next;
  }

  // Helper: convert linked list to array
  private int[] toArray(Leetcode206.ListNode head) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    while (head != null) {
      result.add(head.val);
      head = head.next;
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  @Test
  void testEmptyListIterative() {
    Leetcode206.ListNode head = null;
    assertNull(solver.reverseListIterativeApproach(head));
  }

  @Test
  void testSingleElementIterative() {
    int[] input = {1};
    Leetcode206.ListNode head = buildList(input);
    Leetcode206.ListNode reversed = solver.reverseListIterativeApproach(head);
    assertArrayEquals(new int[]{1}, toArray(reversed));
  }

  @Test
  void testMultipleElementsIterative() {
    int[] input = {1, 2, 3, 4, 5};
    Leetcode206.ListNode head = buildList(input);
    Leetcode206.ListNode reversed = solver.reverseListIterativeApproach(head);
    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));
  }

  @Test
  void testEmptyListRecursive() {
    Leetcode206.ListNode head = null;
    assertNull(solver.reverseListRecursiveApproach(head));
  }

  @Test
  void testSingleElementRecursive() {
    int[] input = {42};
    Leetcode206.ListNode head = buildList(input);
    Leetcode206.ListNode reversed = solver.reverseListRecursiveApproach(head);
    assertArrayEquals(new int[]{42}, toArray(reversed));
  }

  @Test
  void testMultipleElementsRecursive() {
    int[] input = {1, 2, 3, 4, 5};
    Leetcode206.ListNode head = buildList(input);
    Leetcode206.ListNode reversed = solver.reverseListRecursiveApproach(head);
    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(reversed));
  }

  @Test
  void testConsistencyBetweenIterativeAndRecursive() {
    int[] input = {7, 8, 9, 10};
    Leetcode206.ListNode head1 = buildList(input);
    Leetcode206.ListNode head2 = buildList(input);

    int[] iterResult = toArray(solver.reverseListIterativeApproach(head1));
    int[] recResult = toArray(solver.reverseListRecursiveApproach(head2));

    assertArrayEquals(iterResult, recResult,
        "Iterative and Recursive approaches should produce the same result");
  }
}

