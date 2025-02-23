package main;

import java.util.*;

public class Boj15657 {

  static int N, M;
  static int[] arr = new int[10];
  static int[] answer = new int[10];
  static StringBuilder sb = new StringBuilder();

  static void func(int cur) {
    if (cur == M) {
      for (int i = 0; i < M; i++) {
        sb.append(answer[i] + " ");
      }
      sb.append("\n");
      return;
    }

    int start = 0;
    if (cur != 0) {
      for (int i = 0; i < N; i++) {
        if (answer[cur - 1] == arr[i]) {
          start = i;
        }
      }
    }

    for (int i = start; i < N; i++) {
      answer[cur] = arr[i];
      func(cur + 1);
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