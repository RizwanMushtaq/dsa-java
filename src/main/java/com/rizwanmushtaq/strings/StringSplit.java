package com.rizwanmushtaq.strings;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
  public String[] stringSplit(String s, char c) {
    List<String> result = new ArrayList();

    if (s.isEmpty()) {
      return result.toArray(new String[0]);
    }

    if (s.startsWith(String.valueOf(c))) {
      result.toArray(new String[0]);
    }

    String currentWord = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != c) {
        currentWord += s.charAt(i);
      } else {
        result.add(currentWord);
        currentWord = "";
      }

      if (i == s.length() - 1) {
        result.add(currentWord);
        currentWord = "";
      }
    }

    return result.stream().toArray(String[]::new);
  }
}
