package main;

import java.util.*;

public class Boj15649 {

  static int N, M;
  static int[] arr = new int[10];
  static boolean[] isUsed = new boolean[10];
  static StringBuilder sb = new StringBuilder();

  static void func(int k) {
    if (k == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!isUsed[i]) {
        arr[k] = i;
        isUsed[i] = true;
        func(k + 1);
        isUsed[i] = false;
      }
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