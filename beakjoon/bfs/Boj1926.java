package main;

import java.io.*;
import java.util.*;

public class Boj1926 {

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
    boolean[][] visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine(), " ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Node> que = new LinkedList<>();

    int maxNum = 0;
    int count = 0;
    for (int a = 0; a < n; a++) {
      for (int b = 0; b < m; b++) {
        if (board[a][b] == 1 && !visited[a][b]) {
          que.add(new Node(a, b));
          visited[a][b] = true;
          count++;
          int size = 1;

          while (!que.isEmpty()) {
            Node cur = que.remove();
            for (int i = 0; i < 4; i++) {
              int nx = cur.x + dx[i];
              int ny = cur.y + dy[i];
              if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
              }
              if (visited[nx][ny] || board[nx][ny] != 1) {
                continue;
              }
              que.add(new Node(nx, ny));
              visited[nx][ny] = true;
              size++;
            }
          }

          if (maxNum < size) {
            maxNum = size;
          }
        }
      }
    }

    System.out.println(count);
    System.out.println(maxNum);
  }
}
