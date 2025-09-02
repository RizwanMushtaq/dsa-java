package com.rizwanmushtaq.ch2sec1;

public class ShellSort {
  public void sort(Comparable[] a) {
    int n = a.length;
    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1; // 1, 4, 13, 40, 121, ...
    }
    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
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
