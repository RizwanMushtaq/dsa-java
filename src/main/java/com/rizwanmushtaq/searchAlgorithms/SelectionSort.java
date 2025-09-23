package com.rizwanmushtaq.searchAlgorithms;

public class SelectionSort {

  public void sort(Comparable[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      int smallestElementIdx = i;
      for (int j = i + 1; j < n; j++) {
        if (less(a[j], a[smallestElementIdx])) {
          smallestElementIdx = j;
        }
      }
      exch(a, i, smallestElementIdx);
    }
  }

  private boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
