package main;

import java.util.Scanner;

public class Boj1074 {

  static int func(int n, int r, int c) {
    if (n == 0) {
      return 0;
    }
    int half = 1 << (n - 1);
    if (r < half && c < half) {
      return func(n - 1, r, c);
    }
    if (r < half && c >= half) {
      return (half * half) + func(n - 1, r, c - half);
    }
    if (r >= half && c < half) {
      return 2 * (half * half) + func(n - 1, r - half, c);
    }
    return 3 * (half * half) + func(n - 1, r - half, c - half);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), r = in.nextInt(), c = in.nextInt();
    System.out.println(func(n, r, c));
  }
}
