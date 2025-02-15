package main;

import java.io.*;
import java.util.*;

public class Boj5427 {

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int[][] board = new int[n][m];
      Queue<Node> queF = new LinkedList<>();
      Queue<Node> queS = new LinkedList<>();
      int[][] visited_F = new int[n][m];
      int[][] visited_S = new int[n][m];

      for (int i = 0; i < n; i++) {
        String s = input.readLine();
        for (int j = 0; j < m; j++) {
          char c = s.charAt(j);
          if (c == '#') {
            board[i][j] = -1;
          } else {
            if (c == '@') {
              queS.add(new Node(i, j));
              visited_S[i][j] = 1;
            } else if (c == '*') {
              queF.add(new Node(i, j));
              visited_F[i][j] = 1;
            }
            board[i][j] = 0;
          }
        }
      }

      // FIRE
      while (!queF.isEmpty()) {
        Node cur = queF.remove();
        for (int i = 0; i < 4; i++) {
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            continue;
          }
          if (board[nx][ny] == -1) {
            continue;
          }
          if (visited_F[nx][ny] > 0) {
            continue;
          }
          visited_F[nx][ny] = visited_F[cur.x][cur.y] + 1;
          queF.add(new Node(nx, ny));
        }
      }

      // SANGGEUN
      boolean isSucceeded = false;
      while (!queS.isEmpty() && !isSucceeded) {
        Node cur = queS.remove();
        for (int i = 0; i < 4; i++) {
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            System.out.println(visited_S[cur.x][cur.y]);
            isSucceeded = true;
            break;
          }
          if (board[nx][ny] == -1) {
            continue;
          }
          if (visited_S[nx][ny] > 0) {
            continue;
          }
          if (visited_F[nx][ny] != 0 && visited_S[cur.x][cur.y] + 1 >= visited_F[nx][ny]) {
            continue;
          }
          visited_S[nx][ny] = visited_S[cur.x][cur.y] + 1;
          queS.add(new Node(nx, ny));
        }
      }
      if (!isSucceeded) {
        System.out.println("IMPOSSIBLE");
      }
    }
  }
}