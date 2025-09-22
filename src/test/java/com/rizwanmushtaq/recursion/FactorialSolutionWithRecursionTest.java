package com.rizwanmushtaq.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialSolutionWithRecursionTest {
  private final FactorialSolutionWithRecursion factorial = new FactorialSolutionWithRecursion();

  @Test
  void testFactorialOfZero() {
    assertEquals(1, factorial.getFactorial(0));
  }

  @Test
  void testFactorialOfOne() {
    assertEquals(1, factorial.getFactorial(1));
  }

  @Test
  void testFactorialOfPositiveNumber() {
    assertEquals(120, factorial.getFactorial(5));
    assertEquals(3628800, factorial.getFactorial(10));
  }

  @Test
  void testFactorialOfNegativeNumber() {
    assertEquals(-1, factorial.getFactorial(-3));
  }

  @Test
  void testFactorialOfLargeNumber() {
    assertThrows(StackOverflowError.class, () -> factorial.getFactorial(10000));
  }
}

