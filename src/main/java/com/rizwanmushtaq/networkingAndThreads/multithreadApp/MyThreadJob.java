package com.rizwanmushtaq.networkingAndThreads.multithreadApp;

public class MyThreadJob implements Runnable {
  @Override
  public void run() {
    go();
  }

  public void go() {
    doMore();
  }

  public void doMore() {
    System.out.println(Thread.currentThread().getName() + " :top of stack");
    Thread.dumpStack();
  }
}
