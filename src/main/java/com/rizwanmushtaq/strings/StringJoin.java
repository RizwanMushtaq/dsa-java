package com.rizwanmushtaq.strings;

public class StringJoin {
  public String stringJoin(String[] arr, String s) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      if (i != arr.length - 1) {
        result.append(arr[i]).append(s);
      } else {
        result.append(arr[i]);
      }
    }

    return result.toString();
  }
}
