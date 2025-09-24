package com.rizwanmushtaq.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringMatchingTest {
  private StringMatching stringMatching;

  @BeforeEach
  public void setup() {
    stringMatching = new StringMatching();
  }

  @Test
  public void testStringMatch() {
    assertEquals(5, stringMatching.indexOf("hello world", " "));
  }

  @Test
  public void testStringMatchWithLongString() {
    assertEquals(2, stringMatching.indexOf("helloworldOOOOOOO", "ll"));
  }
}
