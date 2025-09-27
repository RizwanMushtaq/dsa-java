package com.rizwanmushtaq.networkingAndThreads.chatApp01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer01 {
  private final String[] adviceList = {
      "eat Healthy",
      "do sports",
      "run everyday",
      "take deep breaths"
  };

  private final Random random = new Random();

  public static void main(String[] args) {
    System.out.println("Starting Server");
    new DailyAdviceServer01().go();
  }

  private String getAdvice() {
    int nextAdvice = random.nextInt(adviceList.length);
    return adviceList[nextAdvice];
  }

  public void go() {
    try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
      serverSocketChannel.bind(new InetSocketAddress(5000));

      while (serverSocketChannel.isOpen()) {
        SocketChannel clientChannel = serverSocketChannel.accept();
        PrintWriter writer =
            new PrintWriter(Channels.newOutputStream((clientChannel)));

        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
