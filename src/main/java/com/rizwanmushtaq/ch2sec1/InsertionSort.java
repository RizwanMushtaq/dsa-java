package com.rizwanmushtaq.ch2sec1;

public class InsertionSort {

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public void sort(Comparable[] a) {
    int n = a.length;
    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  private void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
