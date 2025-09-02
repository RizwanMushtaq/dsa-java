package com.rizwanmushtaq.ch1sec3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  private Stack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new Stack<>();
  }

  @Test
  void testNewStackIsEmpty() {
    assertTrue(stack.isEmpty(), "A new stack should be empty");
    assertEquals(0, stack.size(), "Size of a new stack should be 0");
  }

  @Test
  void testPushIncreasesSize() {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.size(), "Pushing two items should make size = 2");
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
  void testSizeUpdatesCorrectly() {
    stack.push(5);
    stack.push(6);
    assertEquals(2, stack.size(), "Stack size should reflect pushes");
    stack.pop();
    assertEquals(1, stack.size(), "Stack size should decrease after pop");
  }

  @Test
  void testIteratorTraversesInLifoOrder() {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    Iterator<Integer> it = stack.iterator();

    assertTrue(it.hasNext(), "Iterator should have elements");
    assertEquals(3, it.next(), "First element should be the last pushed (3)");
    assertEquals(2, it.next(), "Next should be 2");
    assertEquals(1, it.next(), "Next should be 1");
    assertFalse(it.hasNext(), "Iterator should have no more elements");
  }

  @Test
  void testIteratorThrowsNoSuchElementIfNextCalledWithoutElements() {
    Iterator<Integer> it = stack.iterator();
    assertThrows(NoSuchElementException.class, it::next,
        "Calling next() on empty iterator should throw NoSuchElementException");
  }
}

