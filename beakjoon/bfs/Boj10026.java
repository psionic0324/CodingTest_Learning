package main;

import java.io.*;
import java.util.*;

public class Boj10026 {

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
    int n = Integer.parseInt(input.readLine());
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      String s = input.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = s.charAt(j);
      }
    }

    boolean[][] visited = new boolean[n][n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }

        Queue<Node> que = new LinkedList<>();
        visited[i][j] = true;
        que.add(new Node(i, j));

        while (!que.isEmpty()) {
          Node cur = que.remove();
          for (int k = 0; k < 4; k++) {
            int nx = cur.x + dx[k];
            int ny = cur.y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
              continue;
            }
            if (visited[nx][ny] || board[nx][ny] != board[cur.x][cur.y]) {
              continue;
            }
            visited[nx][ny] = true;
            que.add(new Node(nx, ny));
          }
        }
        count++;
      }
    }
    System.out.print(count + " ");

    // RG 그리고 B
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'G') {
          board[i][j] = 'R';
        }
      }
    }

    count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }

        Queue<Node> que = new LinkedList<>();
        visited[i][j] = true;
        que.add(new Node(i, j));

        while (!que.isEmpty()) {
          Node cur = que.remove();
          for (int k = 0; k < 4; k++) {
            int nx = cur.x + dx[k];
            int ny = cur.y + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
              continue;
            }
            if (visited[nx][ny] || board[nx][ny] != board[cur.x][cur.y]) {
              continue;
            }
            visited[nx][ny] = true;
            que.add(new Node(nx, ny));
          }
        }
        count++;
      }
    }
    System.out.println(count);
  }
}