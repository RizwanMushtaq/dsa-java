package com.rizwanmushtaq.ch1sec3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

  private Queue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new Queue<>();
  }

  @Test
  void testNewQueueIsEmpty() {
    assertTrue(queue.isEmpty(), "A new queue should be empty");
    assertEquals(0, queue.size(), "Size of a new queue should be 0");
  }

  @Test
  void testEnqueueIncreasesSize() {
    queue.enqueue(1);
    queue.enqueue(2);
    assertFalse(queue.isEmpty(), "Queue should not be empty after enqueues");
    assertEquals(2, queue.size(), "Enqueuing two elements should set size = 2");
  }

  @Test
  void testDequeueReturnsItemsInFifoOrder() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    assertEquals(10, queue.dequeue(), "First dequeued item should be the first enqueued (10)");
    assertEquals(20, queue.dequeue(), "Next dequeued item should be 20");
    assertEquals(30, queue.dequeue(), "Next dequeued item should be 30");
    assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
  }

  @Test
  void testDequeueOnEmptyQueueThrowsException() {
    Exception ex = assertThrows(RuntimeException.class, () -> queue.dequeue(),
        "Dequeuing from an empty queue should throw RuntimeException");
    assertEquals("Queue underflow", ex.getMessage());
  }

  @Test
  void testSizeUpdatesCorrectly() {
    queue.enqueue(5);
    queue.enqueue(6);
    assertEquals(2, queue.size(), "Queue size should reflect enqueues");
    queue.dequeue();
    assertEquals(1, queue.size(), "Queue size should decrease after dequeue");
  }

  @Test
  void testIteratorTraversesInFifoOrder() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    Iterator<Integer> it = queue.iterator();

    assertTrue(it.hasNext(), "Iterator should have elements");
    assertEquals(1, it.next(), "First element should be the first enqueued (1)");
    assertEquals(2, it.next(), "Next should be 2");
    assertEquals(3, it.next(), "Next should be 3");
    assertFalse(it.hasNext(), "Iterator should have no more elements");
  }

  @Test
  void testIteratorThrowsNoSuchElementIfNextCalledWithoutElements() {
    Iterator<Integer> it = queue.iterator();
    assertThrows(NoSuchElementException.class, it::next,
        "Calling next() on empty iterator should throw NoSuchElementException");
  }
}

