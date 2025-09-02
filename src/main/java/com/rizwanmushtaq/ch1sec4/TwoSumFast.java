package com.rizwanmushtaq.ch1sec4;

import java.util.Arrays;

public class TwoSumFast {

  public int count(int[] a) {
    int n = a.length;
    int count = 0;
    Arrays.sort(a);
    for (int i = 0; i < n; i++) {
      int j = Arrays.binarySearch(a, -a[i]);
      if (j > i) count++;
    }
    return count;
  }
}
