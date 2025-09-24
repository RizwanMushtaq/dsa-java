package com.rizwanmushtaq.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringJoinTest {
  private StringJoin stringJoin;

  @BeforeEach
  public void setup() {
    stringJoin = new StringJoin();
  }

  @Test
  public void testJoinMultipleString() {
    assertEquals("hello world", stringJoin.stringJoin(new String[]{"hello",
        "world"}, " "));
  }

  @Test
  public void testJoinWithSign() {
    assertEquals("hello&world", stringJoin.stringJoin(new String[]{"hello",
        "world"}, "&"));
  }
}
