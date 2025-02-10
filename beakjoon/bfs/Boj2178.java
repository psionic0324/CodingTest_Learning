package main;

import java.io.*;
import java.util.*;

public class Boj2178 {

  static class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] board = new int[n][m];
    int[][] visited = new int[n][m];
    for (int i = 0; i < n; i++) {
      String s = input.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(0, 0));
    visited[0][0] = 1;
    while (!que.isEmpty()) {
      Node cur = que.remove();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (visited[nx][ny] != 0 || board[nx][ny] == 0) {
          continue;
        }
        que.add(new Node(nx, ny));
        visited[nx][ny] = visited[cur.x][cur.y] + 1;
      }
    }
    System.out.println(visited[n - 1][m - 1]);
  }
}