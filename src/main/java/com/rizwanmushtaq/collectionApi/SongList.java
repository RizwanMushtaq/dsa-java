package com.rizwanmushtaq.collectionApi;

import java.util.*;

public class SongList {
  public static void main(String[] args) {
    System.out.println("Collection API Testing");
    new SongList().goSongList();
    new SongList().goSongStringList();
  }

  public void goSongList() {
    List<Song> songList = new ArrayList<>();
    songList.add(new Song("hello", "abc"));
    songList.add(new Song("vvvvv", "abc"));
    songList.add(new Song("hello", "abc"));
    songList.add(new Song("ggggg", "abc"));
    songList.add(new Song("hello", "abc"));
    songList.add(new Song("ggggg", "abc"));
    songList.add(new Song("hello", "abc"));
    songList.add(new Song("zzzzz", "abc"));
    songList.add(new Song("hello", "abc"));
    System.out.println(songList);

    songList.sort((a, b) -> a.title.compareTo(b.title));
    System.out.println(songList);

    Set<Song> songMap = new HashSet<>(songList);
    System.out.println(songMap);

    Set<Song> songSortedSet = new TreeSet<>(songList);
    System.out.println(songSortedSet);
  }

  public void goSongStringList() {
    List<String> songList = new ArrayList<>();
    songList.add("hello");
    songList.add("zzz");
    songList.add("abc");
    songList.add("abc");
    songList.add("abc");
    songList.add("kkkk");
    songList.add("kkkk");
    songList.add("lll");

    songList.sort((a, b) -> a.compareTo(b));
    System.out.println(songList);

    Set<String> songSet = new HashSet<>(songList);
    System.out.println(songSet);

    Set<String> songSortedSet = new TreeSet<>(songList);
    System.out.println(songSortedSet);
  }

  private class Song implements Comparable<Song> {
    private String title;
    private String author;

    public Song(String title, String author) {
      this.title = title;
      this.author = author;
    }

    public String getTitle() {
      return title;
    }

    public String getAuthor() {
      return author;
    }

    @Override
    public boolean equals(Object song) {
      Song otherSong = (Song) song;
      return title.equals(otherSong.title);
    }

    @Override
    public int hashCode() {
      return title.hashCode();
    }

    @Override
    public String toString() {
      return "{ title: " + title + " author: " + author + " }";
    }

    @Override
    public int compareTo(Song o) {
      return title.compareTo(o.title);
    }
  }
}

