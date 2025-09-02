package com.rizwanmushtaq.ch1sec2;

public class ImmutableConcept {
  public static void main(String[] args) {
    // String are immutable in Java
    String string1 = "Hello";
    String string2 = string1;
    string1 = "world";
    System.out.println(string1);
    System.out.println(string2);

    // Arrays are mutable in Java
    int[] array1 = {1, 2, 3};
    int[] array2 = array1;
    array1[0] = 0;
    System.out.println(array1[0]);
    System.out.println(array2[0]);
  }
}
