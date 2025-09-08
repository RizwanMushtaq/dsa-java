package com.rizwanmushtaq.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LLTest {
  private LL list;

  @BeforeEach
  void setup() {
    list = new LL();
  }

  @Test
  void testEmptyListInitially() {
    assertEquals(0, list.getSize(), "Size should be 0 initially");
  }

  @Test
  void testAddFirst() {
    list.addFirst("A");
    list.addFirst("B");
    list.addFirst("C");
    assertEquals(3, list.getSize(), "Size should be 3 after adding three elements");
  }

  @Test
  void testAddLast() {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    assertEquals(3, list.getSize());
  }

  @Test
  void testAddAtIndexZero() {
    list.addFirst("A");
    list.add(0, "B"); // Insert at beginning
    assertEquals(2, list.getSize());
  }

  @Test
  void testAddAtMiddle() {
    list.addLast("A");
    list.addLast("C");
    list.add(1, "B"); // Insert in middle
    assertEquals(3, list.getSize());
  }

  @Test
  void testAddAtInvalidIndex() {
    list.addLast("A");
    list.add(5, "X"); // Invalid
    assertEquals(1, list.getSize(), "Invalid index should not change size");
  }

  @Test
  void testDeleteFirst() {
    list.addLast("A");
    list.addLast("B");
    list.deleteFirst();
    assertEquals(1, list.getSize(), "Deleting first should reduce size");
  }

  @Test
  void testDeleteFirstOnEmpty() {
    list.deleteFirst(); // Should just print warning
    assertEquals(0, list.getSize());
  }

  @Test
  void testDeleteLast() {
    list.addLast("A");
    list.addLast("B");
    list.deleteLast();
    assertEquals(1, list.getSize());
  }

  @Test
  void testDeleteLastSingleElement() {
    list.addLast("A");
    list.deleteLast();
    assertEquals(0, list.getSize());
  }

  @Test
  void testDeleteAtIndexZero() {
    list.addLast("A");
    list.addLast("B");
    list.delete(0);
    assertEquals(1, list.getSize());
  }

  @Test
  void testDeleteAtMiddleIndex() {
    list.addLast("A");
    list.addLast("B");
    list.addLast("C");
    list.delete(1); // Remove "B"
    assertEquals(2, list.getSize());
  }

  @Test
  void testDeleteAtInvalidIndex() {
    list.addLast("A");
    list.delete(5); // Invalid index
    assertEquals(1, list.getSize());
  }

  @Test
  void testMultipleOperations() {
    list.addFirst("A"); // A
    list.addLast("B");  // A -> B
    list.add(1, "C");   // A -> C -> B
    list.delete(1);     // A -> B
    list.addFirst("D"); // D -> A -> B
    list.deleteLast();  // D -> A
    assertEquals(2, list.getSize(), "After mixed operations, size should be 2");
  }
}

