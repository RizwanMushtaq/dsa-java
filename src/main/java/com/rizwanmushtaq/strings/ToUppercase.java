package com.rizwanmushtaq.strings;

public class ToUppercase {
  public char toUppercase(char c) {

    if (((int) c) >= ((int) 'a') && ((int) c) <= ((int) 'z')) {
      int cIndex = (int) c - (int) 'a';
      int uppercaseCode = cIndex + (int) 'A';
      return (char) uppercaseCode;
    }

    return c;
  }
}
