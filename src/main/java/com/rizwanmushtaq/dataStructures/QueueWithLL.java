package com.rizwanmushtaq.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * First In - First Out
 */
public class QueueWithLL<Item> {
  private Node first; // beginning of queue
  private Node last;  // end of queue
  private int n;     // number of elements on queue

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue underflow");
    }
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) {
      last = null; // to avoid loitering
    }
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
