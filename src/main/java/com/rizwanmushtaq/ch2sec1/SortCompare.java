package com.rizwanmushtaq.ch2sec1;

public class SortCompare {
  public double time(String alg, Comparable[] a) {
    long start = System.currentTimeMillis();
    if (alg.equals("Insertion")) {
      new InsertionSort().sort(a);
    } else if (alg.equals("Selection")) {
      new SelectionSort().sort(a);
    } else if (alg.equals("Shell")) {
      new ShellSort().sort(a);
    } else {
      throw new IllegalArgumentException("Invalid algorithm: " + alg);
    }
    long end = System.currentTimeMillis();
    return (end - start) / 1000.0;
  }
}
