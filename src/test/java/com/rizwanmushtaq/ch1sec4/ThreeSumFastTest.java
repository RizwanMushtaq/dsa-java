package com.rizwanmushtaq.ch1sec4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumFastTest {

  private ThreeSumFast threeSumFast;

  @BeforeEach
  void setUp() {
    threeSumFast = new ThreeSumFast();
  }

  @Test
  void testEmptyArrayReturnsZero() {
    assertEquals(0, threeSumFast.count(new int[]{}),
        "Empty array should return 0 triplets");
  }

  @Test
  void testSingleElementArrayReturnsZero() {
    assertEquals(0, threeSumFast.count(new int[]{5}),
        "Single element cannot form a triplet");
  }

  @Test
  void testTwoElementArrayReturnsZero() {
    assertEquals(0, threeSumFast.count(new int[]{1, -1}),
        "Two elements cannot form a triplet");
  }

  @Test
  void testArrayWithNoZeroSumTriplets() {
    int[] arr = {1, 2, 3, 4, 5};
    assertEquals(0, threeSumFast.count(arr),
        "Array with no zero-sum triplets should return 0");
  }

  @Test
  void testOneValidTriplet() {
    int[] arr = {-3, 1, 2, 5};
    // Only (-3,1,2) sums to 0
    assertEquals(1, threeSumFast.count(arr),
        "Array should contain one zero-sum triplet (-3,1,2)");
  }

  @Test
  void testMultipleValidTriplets() {
    int[] arr = {-1, 0, 1, 2, -2};
    // Triplets: (-1,0,1), (-2,0,2), (-2,-1,3?) no (3 not present), (-2,1,1?) no
    assertEquals(2, threeSumFast.count(arr),
        "Array should contain two zero-sum triplets: (-1,0,1) and (-2,0,2)");
  }

  @Test
  void testArrayWithAllZeros() {
    int[] arr = {0, 0, 0, 0};
    assertEquals(0, threeSumFast.count(arr),
        "Fast implementation does not detect duplicates; four zeros return 0");
  }

  @Test
  void testArrayWithDuplicates() {
    int[] arr = {-1, -1, 2, 0, 0};
    // Triplet (-1, -1, 2) only
    assertEquals(1, threeSumFast.count(arr),
        "Duplicates should still yield correct triplet count (-1,-1,2)");
  }

  @Test
  void testArrayThatRequiresSorting() {
    int[] arr = {4, -1, -3, 0};
    // Sorted = [-3, -1, 0, 4]
    // Triplet: (-3, -1, 4)
    assertEquals(1, threeSumFast.count(arr),
        "Sorting should not affect correctness: one triplet (-3,-1,4)");
  }

  @Test
  void testLargeNumbers() {
    int[] arr = {1_000_000, -500_000, -500_000};
    assertEquals(1, threeSumFast.count(arr),
        "Large numbers should still form a valid triplet (1,000,000,-500,000,-500,000)");
  }
}

