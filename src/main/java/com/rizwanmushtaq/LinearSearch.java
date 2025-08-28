package com.rizwanmushtaq;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: java LinearSearch.java <filename> <target>");
      return;
    }

    String filename = args[0];
    int target = Integer.parseInt(args[1]);

    try (Scanner scanner = new Scanner(new File(filename))) {
      List<Integer> list = new java.util.ArrayList<>();
      int count = 0;
      while (scanner.hasNextInt()) {
        list.add(scanner.nextInt());
        count++;
      }
      System.out.println(count);
      int[] data = list.stream().mapToInt(i -> i).toArray();
      int result = linearSearch(data, target);
      if (result != -1) {
        System.out.println("Element found at index: " + result);
      } else {
        System.out.println("Element not found in the array.");
      }
    } catch (java.io.FileNotFoundException e) {
      System.out.println("File not found: " + filename);
    }
  }
}
