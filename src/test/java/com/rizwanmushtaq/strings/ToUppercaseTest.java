package com.rizwanmushtaq.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToUppercaseTest {
  private ToUppercase toUppercase;

  @BeforeEach
  public void setup() {
    toUppercase = new ToUppercase();
  }

  @Test
  public void testUppercase() {
    assertEquals('A', toUppercase.toUppercase('a'));
    assertEquals('Z', toUppercase.toUppercase('z'));
    assertEquals('1', toUppercase.toUppercase('1'));
    assertEquals('K', toUppercase.toUppercase('K'));
    assertEquals('#', toUppercase.toUppercase('#'));
  }
}
