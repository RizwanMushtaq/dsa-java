package com.rizwanmushtaq.slidingWindowMaximum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Leetcode239Test {
  private Leetcode239 leetcode239;

  @BeforeEach
  void setup() {
    leetcode239 = new Leetcode239();
  }

  @Test
  void testExampleCase() {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] expected = {3, 3, 5, 5, 6, 7};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testSingleElementWindow() {
    int[] nums = {1, 2, 3, 4};
    int k = 1;
    int[] expected = {1, 2, 3, 4};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testWholeArrayAsWindow() {
    int[] nums = {2, 1, 3};
    int k = 3;
    int[] expected = {3};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testAllEqualElements() {
    int[] nums = {5, 5, 5, 5};
    int k = 2;
    int[] expected = {5, 5, 5};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testDecreasingArray() {
    int[] nums = {9, 8, 7, 6, 5};
    int k = 2;
    int[] expected = {9, 8, 7, 6};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testIncreasingArray() {
    int[] nums = {1, 2, 3, 4, 5};
    int k = 2;
    int[] expected = {2, 3, 4, 5};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testLargeK() {
    int[] nums = {4, 2, 12, 11, -5};
    int k = 5;
    int[] expected = {12};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }

  @Test
  void testEmptyArray() {
    int[] nums = {};
    int k = 3;
    int[] expected = {};
    assertArrayEquals(expected, leetcode239.solution(nums, k));
  }
}
