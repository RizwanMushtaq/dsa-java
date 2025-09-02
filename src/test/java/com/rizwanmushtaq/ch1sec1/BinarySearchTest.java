package com.rizwanmushtaq.ch1sec1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTest {

  private BinarySearch search;
  private int[] testArray;

  @BeforeEach
  public void setUp() {
    search = new BinarySearch();
    testArray = new int[]{
        10, 11, 13, 18, 23, 23, 48, 50, 54,
        68, 77, 77, 77, 84, 98, 98, 99
    };
  }

  @Test
  public void testElementAtBeginning() {
    assertEquals(0, search.binarySearch(testArray, 10),
        "Element 10 should be found at index 0 (beginning of the array)");
  }

  @Test
  public void testElementAtMiddle() {
    assertEquals(6, search.binarySearch(testArray, 48),
        "Element 48 should be found at index 6 (middle of the array)");
  }

  @Test
  public void testElementAtEnd() {
    assertEquals(16, search.binarySearch(testArray, 99),
        "Element 99 should be found at index 16 (end of the array)");
  }

  @Test
  public void testDuplicateElement() {
    int result = search.binarySearch(testArray, 23);
    assertTrue(result == 4 || result == 5,
        "Element 23 is duplicated; expected index 4 or 5 but got " + result);
  }

  @Test
  public void testElementNotPresent() {
    assertEquals(-1, search.binarySearch(testArray, 42),
        "Element 42 is not present, so binarySearch should return -1");
  }

  @Test
  public void testEmptyArray() {
    int[] emptyArray = {};
    assertEquals(-1, search.binarySearch(emptyArray, 10),
        "Searching in an empty array should return -1");
  }

  @Test
  public void testSingleElementArrayFound() {
    int[] single = {42};
    assertEquals(0, search.binarySearch(single, 42),
        "Element 42 should be found at index 0 in a single-element array");
  }

  @Test
  public void testSingleElementArrayNotFound() {
    int[] single = {42};
    assertEquals(-1, search.binarySearch(single, 10),
        "Element 10 is not present in a single-element array, so should return -1");
  }

  @Test
  public void testFirstDuplicateElement() {
    int result = search.binarySearch(testArray, 77);
    assertTrue(result >= 10 && result <= 12,
        "Element 77 is duplicated; expected index between 10 and 12 but got " + result);
  }
}

