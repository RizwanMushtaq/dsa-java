package com.rizwanmushtaq.ch2sec1;

public class InsertionSort {

  public void sort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      Comparable currentElement = a[i];
      int previousIndex = i - 1;
      while (previousIndex >= 0 && less(currentElement, a[previousIndex])) {
        a[previousIndex + 1] = a[previousIndex];
        previousIndex--;
      }
      a[previousIndex + 1] = currentElement;
    }
  }

  private boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }
}
