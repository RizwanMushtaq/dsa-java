package com.rizwanmushtaq.networkingAndThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LostUpdateTest {
  public static void main(String[] args) throws InterruptedException {
    Balance balance = new Balance();
    ExecutorService poll = Executors.newFixedThreadPool(25);
    for (int i = 0; i < 1000; i++) {
      poll.execute(() -> balance.increment());
    }

    poll.shutdown();
    if (poll.awaitTermination(1, TimeUnit.MINUTES)) {
      System.out.println("balance: " + balance.getBalance());
    }
    poll.shutdownNow();
  }
}

class Balance {
  private int balance = 0;

  public int getBalance() {
    return balance;
  }

  public void increment() {
    balance++;
  }

  /**
   * To make imcrement opertion atomic use it as
   *
   * public synchronized void increment() {
   *     balance++;
   * }
   */
}