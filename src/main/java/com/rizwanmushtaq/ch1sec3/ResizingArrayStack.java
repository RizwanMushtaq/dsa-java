package com.rizwanmushtaq.ch1sec3;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1]; // stack items
  private int n; // number of elements on stack

  private void resize(int max) {
    assert max >= n;
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < n; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    if (n == a.length) {
      resize(2 * a.length); // double size of array if necessary
    }
    a[n++] = item; // add item
  }

  public Item pop() {
    if (isEmpty()) throw new RuntimeException("Stack underflow");
    Item item = a[--n];
    a[n] = null; // to avoid loitering
    if (n > 0 && n == a.length / 4) {
      resize(a.length / 2); // shrink size of array if necessary
    }
    return item;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  @Override
  public void forEach(Consumer<? super Item> action) {
    Iterable.super.forEach(action);
  }

  @Override
  public Spliterator<Item> spliterator() {
    return Iterable.super.spliterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i;

    public ReverseArrayIterator() {
      i = n - 1;
    }

    @Override
    public boolean hasNext() {
      return i >= 0;
    }

    @Override
    public Item next() {
      return a[i--];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
