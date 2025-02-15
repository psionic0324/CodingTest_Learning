package main;

import java.io.*;
import java.util.*;

public class Boj6593 {

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
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int[] dz = {0, 0, 1, 0, 0, -1};
    int[] dx = {1, 0, 0, -1, 0, 0};
    int[] dy = {0, 1, 0, 0, -1, 0};

    while (true) {
      StringTokenizer st = new StringTokenizer(in.readLine(), " ");
      int h = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      if (h == 0 && n == 0 && m == 0) {
        break;
      }
      int[][][] board = new int[h][n][m];
      int[][][] visited = new int[h][n][m];
      Queue<Node> que = new LinkedList<>();
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
          String s = in.readLine();
          for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '#') {
              board[i][j][k] = -1;
            }
            if (s.charAt(k) == 'S') {
              visited[i][j][k] = 1;
              que.add(new Node(i, j, k));
            } else if (s.charAt(k) == 'E') {
              board[i][j][k] = -2;
            }
          }
        }
        in.readLine();
      }

      int count = 0;
      boolean isEscaped = false;
      while (!que.isEmpty() && !isEscaped) {
        Node cur = que.remove();
        for (int i = 0; i < 6; i++) {
          int nz = cur.z + dz[i];
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m) {
            continue;
          }
          if (board[nz][nx][ny] == -2) {
            isEscaped = true;
            count = visited[cur.z][cur.x][cur.y];
          }
          if (visited[nz][nx][ny] > 0 || board[nz][nx][ny] == -1) {
            continue;
          }
          visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
          que.add(new Node(nz, nx, ny));
        }
      }

      if (isEscaped) {
        System.out.println("Escaped in " + count + " minute(s).");
      } else {
        System.out.println("Trapped!");
      }
    }
  }
}