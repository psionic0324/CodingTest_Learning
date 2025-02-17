package main;

import java.util.*;

public class Boj2447 {

  static StringBuilder sb = new StringBuilder();

  static void func(int i, int j, int n) {
    if ((i / n) % 3 == 1 && (j / n) % 3 == 1) {
      sb.append(" ");
    } else {
      if (n / 3 == 0) {
        sb.append("*");
      } else {
        func(i, j, n / 3);
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        func(i, j, N);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
