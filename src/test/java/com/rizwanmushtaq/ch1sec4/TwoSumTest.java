package com.rizwanmushtaq.ch1sec4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumTest {

  private TwoSum twoSum;

  @BeforeEach
  void setUp() {
    twoSum = new TwoSum();
  }

  @Test
  void testEmptyArrayReturnsZero() {
    assertEquals(0, twoSum.count(new int[]{}),
        "Empty array should return 0 pairs");
  }

  @Test
  void testArrayWithOneElementReturnsZero() {
    assertEquals(0, twoSum.count(new int[]{1}),
        "Single element cannot form a pair");
  }

  @Test
  void testNoZeroSumPairs() {
    int[] arr = {1, 2, 3, 4, 5};
    assertEquals(0, twoSum.count(arr),
        "Array with no zero-sum pairs should return 0");
  }

  @Test
  void testOneValidPair() {
    int[] arr = {-3, 1, 3, 5};
    assertEquals(1, twoSum.count(arr),
        "Array should contain one zero-sum pair: (-3, 3)");
  }

  @Test
  void testMultipleValidPairs() {
    int[] arr = {-1, 1, -2, 2, 3};
    // Valid pairs: (-1,1), (-2,2)
    assertEquals(2, twoSum.count(arr),
        "Array should contain two zero-sum pairs");
  }

  @Test
  void testArrayWithDuplicates() {
    int[] arr = {0, 0, 0};
    // Pairs: choose 2 out of 3 zeros -> C(3,2) = 3
    assertEquals(3, twoSum.count(arr),
        "Three zeros should form 3 zero-sum pairs");
  }

  @Test
  void testMixedWithDuplicates() {
    int[] arr = {-1, -1, 1, 1};
    // Valid pairs: (-1,1), (-1,1), (-1,1), (-1,1) = 4
    assertEquals(4, twoSum.count(arr),
        "Two -1s and two 1s should produce 4 pairs");
  }

  @Test
  void testLargeNumbers() {
    int[] arr = {1_000_000, -1_000_000};
    assertEquals(1, twoSum.count(arr),
        "Large opposite numbers should form one zero-sum pair");
  }
}
