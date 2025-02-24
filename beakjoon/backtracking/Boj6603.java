package main;

import java.util.*;

public class Boj6603 {

  static int N;
  static int[] arr = new int[50];
  static int[] answer = new int[50];
  static boolean[] isUsed = new boolean[50];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      N = in.nextInt();
      if (N == 0) {
        break;
      }
      for (int i = 0; i < N; i++) {
        arr[i] = in.nextInt();
      }
      Arrays.sort(arr, 0, N);
      func(0, 0);
      System.out.println(sb);
      sb.delete(0, sb.length());
    }
  }

  static void func(int cur, int start) {
    if (cur == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(answer[i] + " ");
      }
      sb.append("\n");
    }

    for (int i = start; i < N; i++) {
      if (isUsed[i]) {
        continue;
      }
      answer[cur] = arr[i];
      isUsed[i] = true;
      func(cur + 1, i + 1);
      isUsed[i] = false;
    }
  }
}