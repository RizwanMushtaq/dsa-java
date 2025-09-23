package com.rizwanmushtaq.dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

  private Bag<String> bag;

  @BeforeEach
  void setUp() {
    bag = new Bag<>();
  }

  @Test
  void testNewBagIsEmpty() {
    assertTrue(bag.isEmpty(), "A new bag should be empty");
    assertEquals(0, bag.size(), "Size of a new bag should be 0");
  }

  @Test
  void testAddIncreasesSize() {
    bag.add("Apple");
    bag.add("Banana");

    assertFalse(bag.isEmpty(), "Bag should not be empty after adding items");
    assertEquals(2, bag.size(), "Adding two elements should increase size to 2");
  }

  @Test
  void testIterationReturnsAllItems() {
    bag.add("Apple");
    bag.add("Banana");
    bag.add("Cherry");

    Set<String> seen = new HashSet<>();
    for (String item : bag) {
      seen.add(item);
    }

    assertEquals(3, seen.size(), "Iteration should return all added elements");
    assertTrue(seen.contains("Apple"), "Bag should contain Apple");
    assertTrue(seen.contains("Banana"), "Bag should contain Banana");
    assertTrue(seen.contains("Cherry"), "Bag should contain Cherry");
  }

  @Test
  void testIteratorOnEmptyBagHasNoElements() {
    Iterator<String> it = bag.iterator();
    assertFalse(it.hasNext(), "Iterator of empty bag should have no elements");
  }

  @Test
  void testIteratorThrowsNoSuchElementIfNextCalledOnEmpty() {
    Iterator<String> it = bag.iterator();
    assertThrows(NoSuchElementException.class, it::next,
        "Calling next() on empty bag iterator should throw NoSuchElementException");
  }

  @Test
  void testMultipleAddsAndIteration() {
    bag.add("One");
    bag.add("Two");
    bag.add("Three");
    bag.add("Four");

    int count = 0;
    for (String item : bag) {
      assertNotNull(item, "Iterator should not return null values");
      count++;
    }
    assertEquals(4, count, "Iteration count should match bag size");
  }
}

