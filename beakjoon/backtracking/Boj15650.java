package main;

import java.util.*;

public class Boj15650 {

  static int n, m;
  static int[] arr = new int[11];
  static boolean[] isUsed = new boolean[11];
  static StringBuilder sb = new StringBuilder();

  static void func(int cur) {
    if (cur == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    int start = 1;
    if (cur != 0) {
      start = arr[cur - 1] + 1;
    }
    for (int i = start; i <= n; i++) {
      if (!isUsed[i]) {
        arr[cur] = i;
        isUsed[i] = true;
        func(cur + 1);
        isUsed[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();
    func(0);
    System.out.println(sb);
  }
}
