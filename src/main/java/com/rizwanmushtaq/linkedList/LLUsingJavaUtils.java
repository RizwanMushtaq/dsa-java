package com.rizwanmushtaq.linkedList;

import java.util.LinkedList;

public class LLUsingJavaUtils {
  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    System.out.println(linkedList.size());
    linkedList.addFirst("a");
    linkedList.addFirst("is");
    linkedList.addFirst("this");
    linkedList.add("list");
    System.out.println(linkedList);
    System.out.println(linkedList.size());

    for (int i = 0; i < linkedList.size(); i++) {
      System.out.print(linkedList.get(i) + "->");
    }
    System.out.print("null");
    System.out.println();

    linkedList.removeFirst();
    linkedList.removeLast();
    linkedList.remove(1);
    System.out.println(linkedList);
  }
}
