package main;

import java.util.Scanner;

public class Boj10828 {

  public static int[] stack = new int[10001];
  public static int pos = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String s;

    for (int i = 0; i < N; i++) {
      s = sc.next();
      if (s.contains("push")) {
        push(sc.nextInt());
      } else if (s.contains("pop")) {
        System.out.println(pop());
      } else if (s.contains("size")) {
        System.out.println(size());
      } else if (s.contains("empty")) {
        System.out.println(empty());
      } else if (s.contains("top")) {
        System.out.println(top());
      }
    }
  }

  public static void push(int num) {
    stack[pos] = num;
    pos++;
  }

  public static int pop() {
    if (pos > 0) {
      return stack[--pos];
    }
    return -1;
  }

  public static int size() {
    return pos;
  }

  public static int empty() {
    if (pos == 0) {
      return 1;
    }
    return 0;
  }

  public static int top() {
    if (pos > 0) {
      return stack[pos - 1];
    }
    return -1;
  }
}
