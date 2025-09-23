package com.rizwanmushtaq.unionFindProblem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionFindQuickUnionTest {
  private UnionFindQuickUnion uf;

  @AfterEach
  void tearDown() {
    uf = null;
  }

  @Test
  void testUnionFindWithTinyUFFile() throws FileNotFoundException {
    String filePath = "D:\\coding-projects\\test-data\\tinyUF.txt";

    try (Scanner scanner = new Scanner(new File(filePath))) {

      int n = scanner.nextInt();
      uf = new UnionFindQuickUnion(n);

      while (scanner.hasNextInt()) {
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        if (uf.connected(p, q)) {
          System.out.println(p + " and " + q + " are already connected.");
          continue;
        }

        uf.union(p, q);
        System.out.println("Connected " + p + " and " + q);
      }

      System.out.println("Number of components: " + uf.count());

      assertEquals(2, uf.count(),
          "Union-Find should result in 2 components for tinyUF.txt");
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + filePath);
      throw e;
    }
  }

  @Test
  void testUnionFindWithMediumUFFile() throws FileNotFoundException {
    String filePath = "D:\\coding-projects\\test-data\\mediumUF.txt";

    try (Scanner scanner = new Scanner(new File(filePath))) {

      int n = scanner.nextInt();
      uf = new UnionFindQuickUnion(n);

      while (scanner.hasNextInt()) {
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        if (uf.connected(p, q)) {
          System.out.println(p + " and " + q + " are already connected.");
          continue;
        }

        uf.union(p, q);
        System.out.println("Connected " + p + " and " + q);
      }

      System.out.println("Number of components: " + uf.count());

      assertEquals(3, uf.count(),
          "Union-Find should result in 3 components for mediumUF.txt");
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + filePath);
      throw e;
    }
  }

  @Test
  void testUnionFindWithLargeUFFile() throws FileNotFoundException {
    String filePath = "D:\\coding-projects\\test-data\\largeUF.txt";

    try (Scanner scanner = new Scanner(new File(filePath))) {

      int n = scanner.nextInt();
      uf = new UnionFindQuickUnion(n);

      while (scanner.hasNextInt()) {
        int p = scanner.nextInt();
        int q = scanner.nextInt();

        if (uf.connected(p, q)) {
          System.out.println(p + " and " + q + " are already connected.");
          continue;
        }

        uf.union(p, q);
        System.out.println("Connected " + p + " and " + q);
      }

      System.out.println("Number of components: " + uf.count());

      assertEquals(6, uf.count(),
          "Union-Find should result in 2 components for largeUF.txt");
    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + filePath);
      throw e;
    }
  }
}
