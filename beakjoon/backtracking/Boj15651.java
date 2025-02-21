package main;

import java.util.*;

public class Boj15651 {

  static int[] arr = new int[10];
  static boolean[] isUsed = new boolean[10];
  static int N, M;
  static StringBuilder sb = new StringBuilder();

  static void func(int cur) {
    if (cur == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
    }

    for (int i = 1; i <= N; i++) {
      if (cur == M) {
        break;
      }
      arr[cur] = i;
      isUsed[i] = true;
      func(cur + 1);
      isUsed[i] = false;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    M = in.nextInt();
    func(0);
    System.out.println(sb);
  }
}
