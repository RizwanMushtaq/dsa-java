package com.rizwanmushtaq.strings;

public class IsAlphanumeric {
  public boolean isAlphanumeric(char c) {
    if (((int) c) >= ((int) 'a') && ((int) c) <= ((int) 'z')) {
      return true;
    }

    if (((int) c) >= ((int) 'A') && ((int) c) <= ((int) 'Z')) {
      return true;
    }

    if (((int) c) >= ((int) '0') && ((int) c) <= ((int) '9')) {
      return true;
    }

    return false;
  }
}
