package com.rizwanmushtaq.strings;

public class IsAlphanumeric {
  public boolean isAlphanumeric(char c) {
    return isUppercase(c) || isLowercase(c) || isDigit(c);
  }

  private boolean isLowercase(char c) {
    return ((int) c) >= ((int) 'a') && ((int) c) <= ((int) 'z');
  }

  private boolean isUppercase(char c) {
    return ((int) c) >= ((int) 'A') && ((int) c) <= ((int) 'Z');
  }

  private boolean isDigit(char c) {
    return ((int) c) >= ((int) '0') && ((int) c) <= ((int) '9');
  }
}
