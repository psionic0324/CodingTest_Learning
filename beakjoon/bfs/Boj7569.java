package main;

import java.io.*;
import java.util.*;

public class Boj7569 {

  static class Node {

    int z;
    int x;
    int y;

    public Node(int z, int x, int y) {
      this.z = z;
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine(), " ");
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());
    int[] dx = {1, 0, 0, -1, 0, 0};
    int[] dy = {0, 1, 0, 0, -1, 0};
    int[] dz = {0, 0, 1, 0, 0, -1};
    int[][][] board = new int[h][n][m];
    int[][][] visited = new int[h][n][m];

    Queue<Node> que = new LinkedList<>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(input.readLine(), " ");
        for (int k = 0; k < m; k++) {
          board[i][j][k] = Integer.parseInt(st.nextToken());
          if (board[i][j][k] == 1) {
            que.add(new Node(i, j, k));
            visited[i][j][k] = 1;
          } else if (board[i][j][k] == -1) {
            visited[i][j][k] = -1;
          }
        }
      }
    }

    int maxNum = 1;
    while (!que.isEmpty()) {
      Node cur = que.remove();
      for (int i = 0; i < 6; i++) {
        int nz = cur.z + dz[i];
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (visited[nz][nx][ny] > 0 || board[nz][nx][ny] != 0) {
          continue;
        }
        que.add(new Node(nz, nx, ny));
        visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
        if (maxNum < visited[nz][nx][ny]) {
          maxNum = visited[nz][nx][ny];
        }
      }
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (visited[i][j][k] == 0) {
            System.out.println("-1");
            return;
          }
        }
      }
    }
    System.out.println(maxNum - 1);
  }
}