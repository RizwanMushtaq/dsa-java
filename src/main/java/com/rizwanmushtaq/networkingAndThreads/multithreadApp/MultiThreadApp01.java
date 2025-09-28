package com.rizwanmushtaq.networkingAndThreads.multithreadApp;

public class MultiThreadApp01 {
  public static void main(String[] args) {
    Runnable myThreadJob = new MyThreadJob();

    /**
     * It is no loner recommended approach to use Threads
     */
    Thread t = new Thread(myThreadJob);
    t.start();

    System.out.println(Thread.currentThread().getName() + " : in main");
    Thread.dumpStack();
  }
}
