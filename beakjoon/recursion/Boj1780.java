package main;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1780 {

  static int n;
  static int[][] board = new int[2200][2200];
  static int[] count = new int[3];

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
      count[board[x][y] + 1] += 1;
      return;
    }
    int N = n / 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        func(x + i * N, y + j * N, N);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(in.readLine());
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(in.readLine(), " ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(0, 0, n);
    for (int i = 0; i < 3; i++) {
      System.out.println(count[i]);
    }
  }
}
