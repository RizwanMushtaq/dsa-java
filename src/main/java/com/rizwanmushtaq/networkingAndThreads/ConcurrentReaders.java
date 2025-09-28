package com.rizwanmushtaq.networkingAndThreads;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

public class ConcurrentReaders {
  public static void main(String[] args) {
    /**
     * To avoid ConcurrentModificationException -> use CopyOnWriteArrayList
     * Data Structure
     */
//    List<Chat> chatList = new ArrayList<>();
    List<Chat> chatList = new CopyOnWriteArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    for (int i = 0; i < 5; i++) {
      executorService.execute(() -> chatList.add(new Chat("Hi There")));
      executorService.execute(() -> System.out.println(chatList));
      executorService.execute(() -> System.out.println(chatList));
    }
    executorService.shutdown();
  }
}

final class Chat {
  private final String message;
  private final LocalDateTime timeStamp;

  public Chat(String message) {
    this.message = message;
    this.timeStamp = LocalDateTime.now();
  }

  @Override
  public String toString() {
    String time =
        timeStamp.format(ofLocalizedTime(MEDIUM));
    return time + " " + message;
  }
}
