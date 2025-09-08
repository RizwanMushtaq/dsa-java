package com.rizwanmushtaq.linkedList;

public class LL {
  private Node head;
  private int size;

  public LL() {
    this.head = null;
    this.size = 0;
  }

  public static void main(String args[]) {
    LL list = new LL();
    list.addFirst("a");
    list.addFirst("is");
    list.addLast("list");
    list.addFirst("This");
    list.printList();

    list.add(2, "hello");
    list.printList();
  }

  public int getSize() {
    return this.size;
  }

  // add First
  public void addFirst(String data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      this.size++;
      return;
    }

    newNode.next = head;
    head = newNode;
    this.size++;
  }

  // add Last
  public void addLast(String data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      this.size++;
      return;
    }

    Node currNode = head;
    while (currNode.next != null) {
      currNode = currNode.next;
    }

    currNode.next = newNode;
    newNode.next = null;
    this.size++;
  }

  // insert at specific index
  public void add(int index, String data) {
    if (index > size || index < 0) {
      System.out.println("Invalid Index value");
      return;
    }
    size++;
    Node newNode = new Node(data);
    if (head == null || index == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    Node currNode = head;
    for (int i = 1; i < size; i++) {
      if (i == index) {
        Node nextNode = currNode.next;
        currNode.next = newNode;
        newNode.next = nextNode;
        break;
      }
      currNode = currNode.next;
    }
  }

  // delete First
  public void deleteFirst() {
    if (head == null) {
      System.out.println("The List is empty");
      return;
    }

    head = head.next;
    this.size--;
  }

  // delete Last
  public void deleteLast() {
    if (head == null) {
      System.out.println("The List is empty");
      return;
    }

    // when there is single element
    if (head.next == null) {
      head = null;
      this.size--;
      return;
    }

    Node tempNode = head;
    while (tempNode.next.next != null) {
      tempNode = tempNode.next;
    }

    tempNode.next = null;
    this.size--;
  }

  // print
  public void printList() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    Node currNode = head;
    System.out.println("size of list is " + this.getSize());
    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }

    System.out.println("NULL");
  }

  private class Node {
    String data;
    Node next;

    public Node(String data) {
      this.data = data;
      next = null;
    }
  }
}
