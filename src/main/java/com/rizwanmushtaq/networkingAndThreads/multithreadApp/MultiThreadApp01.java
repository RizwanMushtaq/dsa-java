package com.rizwanmushtaq.networkingAndThreads.multithreadApp;

public class MultiThreadApp01 {
  public static void main(String[] args) {
    /**
     * It is no loner recommended approach to use Threads
     */
    Runnable myThreadJob = new MyThreadJob();
    Thread t = new Thread(myThreadJob);

    t.start();

    System.out.println(Thread.currentThread().getName() + " : in main");
    Thread.dumpStack();
  }
}
