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
    String s = "apple banana";
    char c = ' ';
    String[] expectedArray = {"apple", "banana"};
    assertArrayEquals(
        expectedArray,
        stringSplit.stringSplit(s, c));

    assertArrayEquals(
        new String[0],
        stringSplit.stringSplit("", c));
  }
}
