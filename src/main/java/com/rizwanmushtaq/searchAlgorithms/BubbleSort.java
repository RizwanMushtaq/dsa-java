package com.rizwanmushtaq.searchAlgorithms;

public class BubbleSort {

  public void sort(Comparable[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      boolean isSwapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (a[j].compareTo(a[j + 1]) > 0) {
          swap(a, j, j + 1);
          isSwapped = true;
        }
      }

      /*
       * If no two elements were swapped by inner loop, then it means the array is already sorted.
       * So, we can break the loop early.
       */
      if (!isSwapped) {
        return;
      }
    }
  }

  private void swap(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
