package com.rizwanmushtaq.recursion;

public class FactorialSolutionWithRecursion {
  public Integer getFactorial(Integer num) {
    if (num < 0) {
      return null;
    }

    if (num == 0 || num == 1) {
      return 1;
    }

    return (num * getFactorial(num - 1));
  }
}
