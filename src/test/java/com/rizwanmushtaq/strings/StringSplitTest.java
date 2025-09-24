package com.rizwanmushtaq.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringSplitTest {
  private StringSplit stringSplit;

  @BeforeEach
  public void setup() {
    stringSplit = new StringSplit();
  }

  @Test
  public void testStringSplit() {
    assertArrayEquals(
        new String[]{"apple", "banana"},
        stringSplit.stringSplit("apple banana", ' '));
  }

  @Test
  public void testEmptyString() {
    assertArrayEquals(
        new String[]{},
        stringSplit.stringSplit("", ' '));
  }

  @Test
  public void testStringWithCommas() {
    assertArrayEquals(
        new String[]{"", "hello", "world", ""},
        stringSplit.stringSplit(",hello,world,", ','));
  }

  @Test
  public void testStringWithOnlyCommas() {
    assertArrayEquals(
        new String[]{"", ""},
        stringSplit.stringSplit(",", ','));
  }
}
