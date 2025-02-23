package main;

import java.util.*;

public class Boj15656 {

  static int n, m;
  static int[] arr = new int[10];
  static int[] answer = new int[10];
  static StringBuilder sb = new StringBuilder();

  static void func(int cur) {
    if (cur == m) {
      for (int i = 0; i < m; i++) {
        sb.append(answer[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < n; i++) {
      if (cur == m) {
        continue;
      }
      answer[cur] = arr[i];
      func(cur + 1);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();
    in.nextLine();
    Arrays.fill(arr, 10001);
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    Arrays.sort(arr);
    func(0);
    System.out.println(sb);
  }
}