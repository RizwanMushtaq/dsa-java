package com.rizwanmushtaq.sumQuestions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

  private ThreeSum threeSum;

  @BeforeEach
  void setUp() {
    threeSum = new ThreeSum();
  }

  @Test
  void testEmptyArrayReturnsZero() {
    assertEquals(0, threeSum.count(new int[]{}),
        "Empty array should return 0 triplets");
  }

  @Test
  void testArrayWithLessThanThreeElementsReturnsZero() {
    assertEquals(0, threeSum.count(new int[]{1}),
        "Single element cannot form a triplet");
    assertEquals(0, threeSum.count(new int[]{1, -1}),
        "Two elements cannot form a triplet");
  }

  @Test
  void testNoTripletsSumToZero() {
    int[] arr = {1, 2, 3, 4, 5};
    assertEquals(0, threeSum.count(arr),
        "Array with no zero-sum triplets should return 0");
  }

  @Test
  void testOneValidTriplet() {
    int[] arr = {-1, 0, 1, 2};
    assertEquals(1, threeSum.count(arr),
        "Array should contain exactly one zero-sum triplet: (-1, 0, 1)");
  }

  @Test
  void testMultipleTriplets() {
    int[] arr = {-1, -2, 3, 0, 1, 2};
    // Valid triplets: (-1, -2, 3), (-1, 0, 1), (-2, 0, 2)
    assertEquals(3, threeSum.count(arr),
        "Array should contain three zero-sum triplets");
  }

  @Test
  void testArrayWithDuplicates() {
    int[] arr = {0, 0, 0, 0};
    // Triplets: C(4,3) = 4 ways to pick 3 zeros
    assertEquals(4, threeSum.count(arr),
        "Array with four zeros should contain 4 zero-sum triplets");
  }

  @Test
  void testLargeValues() {
    int[] arr = {1000000, -500000, -500000};
    assertEquals(1, threeSum.count(arr),
        "Large numbers should still correctly form a zero-sum triplet");
  }
}

