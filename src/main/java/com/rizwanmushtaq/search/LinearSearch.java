package com.rizwanmushtaq.search;

public class LinearSearch {
  public int linearSearch(int[] arr, int target) {
    int counter = 0;
    for (int i = 0; i < arr.length; i++) {
      counter++;
      if (arr[i] == target) {
        System.out.println(counter);
        return i;
      }
    }
    System.out.println(counter);
    return -1;
  }
}
