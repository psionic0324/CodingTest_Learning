package main;

import java.util.*;

public class Boj15654 {

  static int N, M;
  static StringBuilder sb = new StringBuilder();
  static int[] arr = new int[10];
  static int[] answer = new int[10];
  static boolean[] isUsed = new boolean[10];

  static void func(int cur) {
    if (cur == M) {
      for (int i = 0; i < M; i++) {
        sb.append(answer[i] + " ");
      }
      sb.append("\n");
    }
    for (int i = 0; i < N; i++) {
      if (isUsed[i]) {
        continue;
      }
      answer[cur] = arr[i];
      isUsed[i] = true;
      func(cur + 1);
      isUsed[i] = false;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    M = in.nextInt();
    in.nextLine();
    Arrays.fill(arr, 10001);
    for (int i = 0; i < N; i++) {
      arr[i] = in.nextInt();
    }
    Arrays.sort(arr);
    func(0);
    System.out.println(sb);
  }
}