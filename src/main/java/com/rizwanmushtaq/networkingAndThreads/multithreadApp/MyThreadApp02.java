package com.rizwanmushtaq.networkingAndThreads.multithreadApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadApp02 {
  public static void main(String[] args) {
    Runnable myThreadJob = new MyThreadJob();
    
    /**
     * A Better alternation to run Threads
     * Don't Manage the threads at all
     */
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(myThreadJob);

    System.out.println(Thread.currentThread().getName() + " : in main");
    Thread.dumpStack();
  }
}
