package main;

import java.util.Scanner;

public class Boj1629 {

  static long func(int a, int b, int c) {
    if (b <= 1) {
      return a % c;
    }
    long num = func(a, b / 2, c);
    num = num * num % c;
    if (b % 2 == 0) {
      return num;
    }
    return num * a % c;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
    System.out.println(func(a, b, c));
  }
}
