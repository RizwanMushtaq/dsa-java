package com.rizwanmushtaq.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsAlphanumericTest {
  private IsAlphanumeric isAlphanumeric;

  @BeforeEach
  public void setup() {
    isAlphanumeric = new IsAlphanumeric();
  }

  @Test
  public void testAlphabets() {
    assertEquals(true, isAlphanumeric.isAlphanumeric('b'));
    assertEquals(true, isAlphanumeric.isAlphanumeric('Z'));
    assertEquals(true, isAlphanumeric.isAlphanumeric('A'));
    assertEquals(false, isAlphanumeric.isAlphanumeric('#'));
  }

  @Test
  public void testDigits() {
    assertEquals(true, isAlphanumeric.isAlphanumeric('5'));
    assertEquals(true, isAlphanumeric.isAlphanumeric('9'));
    assertEquals(true, isAlphanumeric.isAlphanumeric('0'));
  }
}
