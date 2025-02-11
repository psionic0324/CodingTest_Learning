package main;

import java.io.*;
import java.util.*;

public class Boj7576 {

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
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] board = new int[n][m];
    int[][] visited = new int[n][m];
    Queue<Node> que = new LinkedList<>();
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(input.readLine(), " ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 1) {
          que.add(new Node(i, j));
          visited[i][j] = 1;
        } else if (board[i][j] == -1) {
          visited[i][j] = -1;
        }
      }
    }

    int maxNum = 1;
    while (!que.isEmpty()) {
      Node cur = que.remove();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (visited[nx][ny] > 0 || board[nx][ny] != 0) {
          continue;
        }
        que.add(new Node(nx, ny));
        visited[nx][ny] = visited[cur.x][cur.y] + 1;
        if (maxNum < visited[nx][ny]) {
          maxNum = visited[nx][ny];
        }
      }
    }

    boolean isSuccess = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j] == 0) {
          isSuccess = false;
        }
      }
    }
    if (isSuccess) {
      System.out.println(maxNum - 1);
    } else {
      System.out.println(-1);
    }
  }
}