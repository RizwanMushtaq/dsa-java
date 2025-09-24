package com.rizwanmushtaq.TwoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainerWithMostWaterL11Test {

  private final ContainerWithMostWaterL11 solver = new ContainerWithMostWaterL11();

  @Test
  void testExampleCase() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = solver.maxArea(height);
    assertEquals(49, result, "Expected max area is 49");
  }

  @Test
  void testTwoBarsOnly() {
    int[] height = {1, 1};
    int result = solver.maxArea(height);
    assertEquals(1, result, "Only two bars, area is min(1,1) * 1 = 1");
  }

  @Test
  void testIncreasingHeights() {
    int[] height = {1, 2, 3, 4, 5};
    int result = solver.maxArea(height);
    assertEquals(6, result, "Max area should be between bar 2 and bar 5 → min(2,5)*3 = 6");
  }

  @Test
  void testDecreasingHeights() {
    int[] height = {5, 4, 3, 2, 1};
    int result = solver.maxArea(height);
    assertEquals(6, result, "Max area should be between bar 5 and bar 2 → min(5,2)*3 = 6");
  }

  @Test
  void testAllEqualHeights() {
    int[] height = {4, 4, 4, 4};
    int result = solver.maxArea(height);
    assertEquals(12, result, "Max area = min(4,4) * distance 3 = 12");
  }

  @Test
  void testTallEnds() {
    int[] height = {10, 1, 1, 10};
    int result = solver.maxArea(height);
    assertEquals(30, result, "Max area should be ends: min(10,10)*3 = 30");
  }

  @Test
  void testLargeInput() {
    int n = 1000;
    int[] height = new int[n];
    for (int i = 0; i < n; i++) {
      height[i] = i % 100; // repeating pattern
    }
    int result = solver.maxArea(height);
    assertTrue(result > 0, "Large input should return a positive max area");
  }
}

