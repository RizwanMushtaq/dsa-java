package com.rizwanmushtaq.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinearSearchTest {

  private LinearSearch search;
  private int[] testArray;

  @BeforeEach
  void setUp() {
    search = new LinearSearch();
    testArray = new int[]{
        23, 50, 10, 99, 18, 23, 98, 84, 11, 10,
        48, 77, 13, 54, 98, 77, 77, 68
    };
  }

  @Test
  void testElementPresent() {
    assertEquals(2, search.linearSearch(testArray, 10));
  }

  @Test
  void testElementAtBeginning() {
    assertEquals(0, search.linearSearch(testArray, 23));
  }

  @Test
  void testElementAtEnd() {
    assertEquals(17, search.linearSearch(testArray, 68));
  }

  @Test
  void testElementNotPresent() {
    assertEquals(-1, search.linearSearch(testArray, 999));
  }
}