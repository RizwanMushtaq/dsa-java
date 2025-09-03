package com.rizwanmushtaq.ch2sec2;

import java.util.ArrayList;

/*
 * MergeSort class implements the merge sort algorithm to sort an array of Comparable objects.
 * It uses a divide-and-conquer approach to recursively split the array into halves,
 * sort each half, and then merge the sorted halves back together.
 * The algorithm has a time complexity of O(n log n) and is stable.
 * The space complexity is O(n) due to the temporary array used for merging.
 */
public class MergeSort {
  static ArrayList<Comparable> temp;

  public static void sort(Comparable[] a) {
    temp = new ArrayList<>();
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid); // Sort left half
    sort(a, mid + 1, hi); // Sort right half
    merge(a, lo, mid, hi); // Merge results
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    System.out.println("Merging from " + lo + " to " + hi);

    int i = lo, j = mid + 1;
    while (i <= mid && j <= hi) {
      if (less(a[i], a[j])) {
        temp.add(a[i]);
        i++;
      } else {
        temp.add(a[j]);
        j++;
      }
    }

    while (i <= mid) {
      temp.add(a[i]);
      i++;
    }

    while (j <= hi) {
      temp.add(a[j]);
      j++;
    }

    for (int idx = 0; idx < temp.size(); idx++) {
      a[idx + lo] = temp.get(idx);
    }

    temp.clear();
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }
}
