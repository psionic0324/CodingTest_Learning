package main;

import java.io.*;

public class Boj1992 {

  static int[][] board = new int[65][65];
  static StringBuilder sb = new StringBuilder();

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
      sb.append(board[x][y]);
      return;
    }
    sb.append("(");
    int hn = n / 2;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        func(x + i * hn, y + j * hn, hn);
      }
    }
    sb.append(")");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    for (int i = 0; i < N; i++) {
      String s = in.readLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }

    func(0, 0, N);
    System.out.println(sb);
  }
}
