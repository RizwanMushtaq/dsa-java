package com.rizwanmushtaq.dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayStackTest {

  private ResizingArrayStack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new ResizingArrayStack<>();
  }

  @Test
  void testNewStackIsEmpty() {
    assertTrue(stack.isEmpty(), "New stack should be empty");
    assertEquals(0, stack.size(), "New stack should have size 0");
  }

  @Test
  void testPushIncreasesSize() {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.size(), "Stack size should be 2 after two pushes");
    assertFalse(stack.isEmpty(), "Stack should not be empty after pushes");
  }

  @Test
  void testPopReturnsLastPushedElement() {
    stack.push(10);
    stack.push(20);
    assertEquals(20, stack.pop(), "Pop should return the last pushed element (20)");
    assertEquals(10, stack.pop(), "Next pop should return the earlier pushed element (10)");
    assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
  }

  @Test
  void testPopOnEmptyStackThrowsException() {
    Exception ex = assertThrows(RuntimeException.class, () -> stack.pop(),
        "Popping an empty stack should throw RuntimeException");
    assertEquals("Stack underflow", ex.getMessage());
  }

  @Test
  void testStackResizesCorrectlyWhenGrowing() {
    // Push more elements than the default capacity (assumed to be 1)
    for (int i = 0; i < 100; i++) {
      stack.push(i);
    }
    assertEquals(100, stack.size(), "Stack should resize automatically and hold 100 elements");
    assertEquals(99, stack.pop(), "Last pushed element (99) should be popped correctly");
  }

  @Test
  void testStackResizesCorrectlyWhenShrinking() {
    // Push then pop enough to trigger shrinking
    for (int i = 0; i < 32; i++) {
      stack.push(i);
    }
    for (int i = 0; i < 24; i++) {
      stack.pop();
    }
    assertEquals(8, stack.size(), "Stack should shrink after popping enough elements");
  }

  @Test
  void testIteratorTraversesInReverseOrder() {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    Iterator<Integer> it = stack.iterator();
    assertTrue(it.hasNext(), "Iterator should have next initially");
    assertEquals(3, it.next(), "First element from iterator should be the last pushed (3)");
    assertEquals(2, it.next(), "Next should be 2");
    assertEquals(1, it.next(), "Next should be 1");
    assertFalse(it.hasNext(), "Iterator should have no more elements");
  }

  @Test
  void testIteratorRemoveThrowsException() {
    stack.push(1);
    Iterator<Integer> it = stack.iterator();
    assertThrows(UnsupportedOperationException.class, it::remove,
        "Iterator.remove() should throw UnsupportedOperationException");
  }

  @Test
  void testForEachIteratesInReverseOrder() {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    StringBuilder sb = new StringBuilder();
    stack.forEach(sb::append);

    assertEquals("321", sb.toString(), "forEach should iterate in reverse order (LIFO)");
  }
}

