package com.rizwanmushtaq.networkingAndThreads.chatApp01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient01 {
  public static void main(String[] args) {
    System.out.println("Starting Client");
    new DailyAdviceClient01().go();
  }

  public void go() {
    InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
    try (SocketChannel socketChannel = SocketChannel.open(serverAddress)) {
      Reader channelReader = Channels.newReader(socketChannel,
          StandardCharsets.UTF_8.name());
      BufferedReader reader = new BufferedReader(channelReader);
      String advice = reader.readLine();
      System.out.println("Adive for today is: " + advice);
      reader.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
