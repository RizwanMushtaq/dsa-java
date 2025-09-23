package com.rizwanmushtaq.sumQuestions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumFastTest {

  private TwoSumFast twoSumFast;

  @BeforeEach
  void setUp() {
    twoSumFast = new TwoSumFast();
  }

  @Test
  void testEmptyArrayReturnsZero() {
    assertEquals(0, twoSumFast.count(new int[]{}),
        "Empty array should return 0 pairs");
  }

  @Test
  void testSingleElementArrayReturnsZero() {
    assertEquals(0, twoSumFast.count(new int[]{5}),
        "Single element cannot form a pair");
  }

  @Test
  void testNoZeroSumPairs() {
    int[] arr = {1, 2, 3, 4, 5};
    assertEquals(0, twoSumFast.count(arr),
        "Array with no zero-sum pairs should return 0");
  }

  @Test
  void testOneValidPair() {
    int[] arr = {-3, 1, 3, 5};
    assertEquals(1, twoSumFast.count(arr),
        "Array should contain one zero-sum pair: (-3, 3)");
  }

  @Test
  void testMultipleValidPairs() {
    int[] arr = {-1, 1, -2, 2, 3};
    // Pairs: (-1,1), (-2,2)
    assertEquals(2, twoSumFast.count(arr),
        "Array should contain two zero-sum pairs");
  }

  @Test
  void testArrayWithDuplicatesZeros() {
    int[] arr = {0, 0, 0};
    // TwoSumFast counts only unique matches, so only 1 pair (0,0) detected
    assertEquals(1, twoSumFast.count(arr),
        "Three zeros should still count as one pair with TwoSumFast");
  }

  @Test
  void testDuplicatesCountedSeparately() {
    int[] arr = {-1, -1, 1, 1};
    assertEquals(2, twoSumFast.count(arr),
        "TwoSumFast counts duplicate pairs separately");
  }

  @Test
  void testLargeNumbers() {
    int[] arr = {1_000_000, -1_000_000};
    assertEquals(1, twoSumFast.count(arr),
        "Large opposite numbers should form one zero-sum pair");
  }

  @Test
  void testArrayThatRequiresSorting() {
    int[] arr = {4, -4, 2, -2, 0};
    // Sorted array = [-4, -2, 0, 2, 4]
    // Pairs: (-4,4), (-2,2)
    assertEquals(2, twoSumFast.count(arr),
        "TwoSumFast should still count correctly after sorting input");
  }
}

