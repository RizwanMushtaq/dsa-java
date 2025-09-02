package com.rizwanmushtaq.ch1sec1;

public class BinarySearch {
  public int binarySearch(int[] arr, int target) {
    int counter = 0;
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      counter++;
      int mid = left + (right - left) / 2;

      if (arr[mid] == target) {
        System.out.println(counter);
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println(counter);
    return -1;
  }
}
