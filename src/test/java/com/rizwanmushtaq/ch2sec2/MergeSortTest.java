package com.rizwanmushtaq.ch2sec2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {

  @Test
  void testEmptyArray() {
    Integer[] arr = {};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{}, arr, "Empty array should remain unchanged");
  }

  @Test
  void testSingleElementArray() {
    Integer[] arr = {42};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{42}, arr, "Single element array should remain unchanged");
  }

  @Test
  void testAlreadySortedArray() {
    Integer[] arr = {1, 2, 3, 4, 5};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr, "Already sorted array should remain unchanged");
  }

  @Test
  void testReverseSortedArray() {
    Integer[] arr = {5, 4, 3, 2, 1};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr, "Reverse sorted array should be sorted ascending");
  }

  @Test
  void testArrayWithDuplicates() {
    Integer[] arr = {4, 2, 4, 1, 3, 2};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 2, 3, 4, 4}, arr, "Array with duplicates should be sorted");
  }

  @Test
  void testArrayWithNegativeNumbers() {
    Integer[] arr = {3, -1, 4, -5, 2, 0};
    MergeSort.sort(arr);
    assertArrayEquals(new Integer[]{-5, -1, 0, 2, 3, 4}, arr, "Array with negatives should be sorted correctly");
  }

  @Test
  void testStrings() {
    String[] arr = {"pear", "apple", "orange", "banana"};
    MergeSort.sort(arr);
    assertArrayEquals(new String[]{"apple", "banana", "orange", "pear"}, arr,
        "String array should be sorted lexicographically");
  }

  @Test
  void testLargeArray() {
    Integer[] arr = new Integer[1000];
    for (int i = 0; i < 1000; i++) {
      arr[i] = 1000 - i;
    }
    MergeSort.sort(arr);

    for (int i = 0; i < 1000; i++) {
      assertEquals(i + 1, arr[i], "Large array should be sorted correctly");
    }
  }
}
