package com.rizwanmushtaq.ch2sec1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SortCompareTest {

  private SortCompare sortCompare;
  private Random random;

  @BeforeEach
  void setUp() {
    sortCompare = new SortCompare();
    random = new Random(42); // fixed seed for reproducibility
  }

  private Integer[] generateRandomArray(int size) {
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++) {
      arr[i] = random.nextInt(size);
    }
    return arr;
  }

  @Test
  void testInsertionVsSelectionOnSmallArray() {
    Integer[] arr1 = generateRandomArray(2000);
    Integer[] arr2 = arr1.clone();
    Integer[] arr3 = arr1.clone();

    double selectionTime = sortCompare.time("Selection", arr1);
    double insertionTime = sortCompare.time("Insertion", arr2);
    double shellTime = sortCompare.time("Shell", arr3);

    System.out.println("SelectionSort (2000 items): " + selectionTime + "s");
    System.out.println("InsertionSort (2000 items): " + insertionTime + "s");
    System.out.println("ShellSort (2000 items): " + shellTime + "s");

    // Just check they finish within reasonable time (< 5s each for small input)
    assertTrue(insertionTime < 5, "InsertionSort should finish in < 5s");
    assertTrue(selectionTime < 5, "SelectionSort should finish in < 5s");
  }

  @Test
  void testInsertionVsShellOnLargerArray() {
    Integer[] arr1 = generateRandomArray(50_000);
    Integer[] arr2 = arr1.clone();
    Integer[] arr3 = arr1.clone();

    double selectionTime = sortCompare.time("Selection", arr1);
    double insertionTime = sortCompare.time("Insertion", arr2);
    double shellTime = sortCompare.time("Shell", arr3);

    System.out.println("SelectionSort (50k items): " + selectionTime + "s");
    System.out.println("InsertionSort (50k items): " + insertionTime + "s");
    System.out.println("ShellSort (50k items): " + shellTime + "s");

    // Expect ShellSort to be significantly faster
    assertTrue(shellTime < insertionTime,
        "ShellSort should outperform InsertionSort on large arrays");
  }
}

