package com.rizwanmushtaq.ch1section4;

import java.util.Arrays;

public class ThreeSumFast {

  public int count(int[] a) {
    int n = a.length;
    int count = 0;
    Arrays.sort(a);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int k = Arrays.binarySearch(a, -(a[i] + a[j]));
        if (k > j) count++;
      }
    }
    return count;
  }
}
