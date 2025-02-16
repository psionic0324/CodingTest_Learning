package main;

import java.util.Scanner;

public class Boj11729 {

  static StringBuilder sb = new StringBuilder();

  static void func(int a, int b, int n) {
    if (n == 1) {
      sb.append(a + " " + b + "\n");
      return;
    }
    func(a, 6 - a - b, n - 1);
    sb.append(a + " " + b + "\n");
    func(6 - a - b, b, n - 1);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println((1 << n) - 1);
    func(1, 3, n);
    System.out.println(sb);
  }
}