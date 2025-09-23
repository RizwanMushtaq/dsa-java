package com.rizwanmushtaq.sortingAlgorithms;

/*
 * QuickSort class implements the quick sort algorithm to sort an array of Comparable objects.
 * It uses a divide-and-conquer approach to recursively partition the array around a pivot element,
 * sorting elements less than the pivot to its left and elements greater than the pivot to its right.
 * The algorithm has an average time complexity of O(n log n) but can degrade to O(n^2) in the worst case.
 * The space complexity is O(log n) due to the recursive call stack. If we
 * ignore recursive call stack, it will O(1)
 */

public class QuickSort {
  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;

    System.out.println("Sorting from " + lo + " to " + hi);
    int pivotIdx = partition(a, lo, hi);
    sort(a, lo, pivotIdx - 1); // Sort left half
    sort(a, pivotIdx + 1, hi); // Sort right half
  }

  public static int partition(Comparable[] a, int lo, int hi) {
    Comparable pivot = a[hi];
    int idx = lo - 1;

    for (int j = lo; j < hi; j++) {
      // logic to place elements less than or equal to pivot on the left
      // side, so for ascending order sorting
      if (a[j].compareTo(pivot) <= 0) {
        idx++;
        swap(a, idx, j);
      }
      /*
      * For descending order sorting, use the following condition instead:
        if (a[j].compareTo(pivot) >= 0) {
          idx++;
          swap(a, idx, j);
        }
       */
    }

    idx++;
    swap(a, idx, hi);
    return idx;
  }

  private static void swap(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
