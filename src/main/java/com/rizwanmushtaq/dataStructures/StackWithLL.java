package com.rizwanmushtaq.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Last In - Last Out
 */
public class StackWithLL<Item> {
  private Node top; // top of stack
  private int n; // size of the stack

  public boolean isEmpty() {
    return top == null;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    Node oldTop = top;
    top = new Node();
    top.item = item;
    top.next = oldTop;
    n++;
  }

  public Item pop() {
    if (isEmpty()) throw new RuntimeException("Stack underflow");
    Item item = top.item;
    top = top.next;
    n--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class Node {
    Item item;
    Node next;
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = top;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
