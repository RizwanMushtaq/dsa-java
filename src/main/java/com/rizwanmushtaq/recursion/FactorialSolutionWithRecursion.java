package com.rizwanmushtaq.recursion;

public class FactorialSolutionWithRecursion {
  public int getFactorial(int num) {
    if (num < 0) {
      return -1;
    }

    if (num == 0 || num == 1) {
      return 1;
    }

    return num * getFactorial(num - 1);
  }
}
