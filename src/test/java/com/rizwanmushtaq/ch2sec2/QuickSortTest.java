package com.rizwanmushtaq.ch2sec2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

  @Test
  void testEmptyArray() {
    Integer[] arr = {};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{}, arr, "Empty array should remain unchanged");
  }

  @Test
  void testSingleElementArray() {
    Integer[] arr = {42};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{42}, arr, "Single element array should remain unchanged");
  }

  @Test
  void testSortedArray() {
    Integer[] arr = {1, 2, 3, 4, 5};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr,
        "Already sorted array should remain sorted");
  }

  @Test
  void testReverseSortedArray() {
    Integer[] arr = {5, 4, 3, 2, 1};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr,
        "Reverse sorted array should be sorted ascending");
  }

  @Test
  void testArrayWithDuplicates() {
    Integer[] arr = {3, 5, 3, 1, 2, 1};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 1, 2, 3, 3, 5}, arr,
        "Array with duplicates should be sorted correctly");
  }

  @Test
  void testArrayWithNegativeNumbers() {
    Integer[] arr = {-3, -1, -7, 2, 0, 5};
    QuickSort.sort(arr);
    assertArrayEquals(new Integer[]{-7, -3, -1, 0, 2, 5}, arr,
        "Array with negatives should be sorted correctly");
  }

  @Test
  void testMediumArray() {
    Integer[] arr = new Integer[1000];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr.length - i; // descending order
    }

    QuickSort.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      assertEquals(i + 1, arr[i], "Medium array (1000 elements) should be sorted correctly");
    }
  }

  @Test
  void testLargeArrayPerformance() {
    int n = 100_000;
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * n); // random integers
    }

    QuickSort.sort(arr);

    // Verify sorted
    for (int i = 1; i < arr.length; i++) {
      assertTrue(arr[i - 1] <= arr[i], "Large array should be sorted in ascending order");
    }
  }

  @Test
  void testStringArray() {
    String[] arr = {"pear", "apple", "orange", "banana"};
    QuickSort.sort(arr);
    assertArrayEquals(new String[]{"apple", "banana", "orange", "pear"}, arr,
        "String array should be sorted lexicographically");
  }
}

