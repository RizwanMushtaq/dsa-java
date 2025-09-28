package com.rizwanmushtaq.networkingAndThreads.rizwanAndMogheeApp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RizwanAndMogheeTest {
  public static void main(String[] args) {
    BankAccount account = new BankAccount();
    RizwanAndMogheeJob moghee = new RizwanAndMogheeJob("moghee", account, 100);
    RizwanAndMogheeJob rizwan = new RizwanAndMogheeJob("rizwan", account, 50);

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(rizwan);
    executorService.execute(moghee);

    executorService.shutdown();
  }
}

class RizwanAndMogheeJob implements Runnable {
  private String name;
  private BankAccount account;
  private int amountToSpend;

  public RizwanAndMogheeJob(String name, BankAccount account,
                            int amountToSpend) {
    this.name = name;
    this.account = account;
    this.amountToSpend = amountToSpend;
  }

  @Override
  public void run() {
    goShopping(name, amountToSpend);
  }

  private void goShopping(String name, int amount) {
    System.out.println(name + " is about to spend");
    account.spend(name, amount);
    System.out.println(name + " finishes spending");
  }
}

class BankAccount {
  private int balance = 100;

  public int getBalance() {
    return balance;
  }

  public synchronized void spend(String name, int amount) {
    if (balance > amount) {
      balance = balance - amount;

      if (balance < 0) {
        System.out.println("Overdrawn");
      }
    } else {
      System.out.println("Sorry not enough for " + name);
    }
  }
}

