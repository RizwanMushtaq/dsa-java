package com.rizwanmushtaq.strings;

public class StringMatching {
  public int indexOf(String s, String t) {
    int index = -1;

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        if (t.charAt(j) == s.charAt(i + j)) {
          if (j == t.length() - 1) {
            return i;
          }
        } else {
          break;
        }
      }
    }

    return index;
  }
}
