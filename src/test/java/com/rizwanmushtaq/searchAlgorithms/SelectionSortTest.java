package com.rizwanmushtaq.searchAlgorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionSortTest {

  private SelectionSort selectionSort;

  @BeforeEach
  void setUp() {
    selectionSort = new SelectionSort();
  }

  @Test
  void testEmptyArray() {
    Integer[] arr = {};
    selectionSort.sort(arr);
    assertArrayEquals(new Integer[]{}, arr, "Sorting empty array should return empty array");
  }

  @Test
  void testSingleElementArray() {
    Integer[] arr = {42};
    selectionSort.sort(arr);
    assertArrayEquals(new Integer[]{42}, arr, "Single element array should remain unchanged");
  }

  @Test
  void testAlreadySortedArray() {
    Integer[] arr = {1, 2, 3, 4, 5};
    selectionSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr,
        "Already sorted array should remain unchanged");
  }

  @Test
  void testReverseSortedArray() {
    Integer[] arr = {5, 4, 3, 2, 1};
    selectionSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr,
        "Reverse sorted array should be sorted in ascending order");
  }

  @Test
  void testUnsortedArrayWithDuplicates() {
    Integer[] arr = {3, 1, 2, 3, 1};
    selectionSort.sort(arr);
    assertArrayEquals(new Integer[]{1, 1, 2, 3, 3}, arr,
        "Array with duplicates should be sorted correctly");
  }

  @Test
  void testStringArray() {
    String[] arr = {"banana", "apple", "cherry", "apple"};
    selectionSort.sort(arr);
    assertArrayEquals(new String[]{"apple", "apple", "banana", "cherry"}, arr,
        "String array should be sorted lexicographically");
  }

  @Test
  void testCustomComparableObjects() {
    Person[] arr = {
        new Person("Charlie", 30),
        new Person("Alice", 25),
        new Person("Bob", 20)
    };
    selectionSort.sort(arr);
    assertEquals("Bob", arr[0].name, "Youngest person should come first");
    assertEquals("Alice", arr[1].name, "Alice should be second");
    assertEquals("Charlie", arr[2].name, "Charlie should be last");
  }

  // helper comparable class
  private static class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public int compareTo(Person other) {
      return Integer.compare(this.age, other.age); // sort by age
    }
  }
}