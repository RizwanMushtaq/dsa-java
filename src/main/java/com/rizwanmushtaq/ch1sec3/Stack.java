package com.rizwanmushtaq.ch1sec3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> {
  private Node first; // top of stack
  private int n; // size of the stack

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    n++;
  }

  public Item pop() {
    if (isEmpty()) throw new RuntimeException("Stack underflow");
    Item item = first.item;
    first = first.next;
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
    private Node current = first;

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
