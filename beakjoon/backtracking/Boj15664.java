package main;

import java.util.*;

public class Boj15664 {

  static int N, M;
  static int[] arr = new int[10];
  static int[] answer = new int[10];
  static StringBuilder sb = new StringBuilder();

  static void func(int cur, int start) {
    if (cur == M) {
      for (int i = 0; i < M; i++) {
        sb.append(answer[i] + " ");
      }
      sb.append("\n");
      return;
    }

    int tmp = -1;
    for (int i = start; i < N; i++) {
      if (tmp != arr[i]) {
        tmp = arr[i];
        answer[cur] = arr[i];
        func(cur + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    M = in.nextInt();
    in.nextLine();
    for (int i = 0; i < N; i++) {
      arr[i] = in.nextInt();
    }
    Arrays.sort(arr, 0, N);
    func(0, 0);
    System.out.println(sb);
  }
}