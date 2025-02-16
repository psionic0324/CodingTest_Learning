package main;

import java.io.*;
import java.util.*;

public class Boj2630 {

  static int[][] board = new int[130][130];
  static int[] cnt = new int[2];

  static boolean check(int x, int y, int n) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (board[x][y] != board[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  static void func(int x, int y, int n) {
    if (check(x, y, n)) {
      cnt[board[x][y]] += 1;
      return;
    }
    int hn = n / 2;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        func(x + i * hn, y + j * hn, hn);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine(), " ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(0, 0, N);
    for (int i = 0; i < 2; i++) {
      System.out.println(cnt[i]);
    }
  }
}
