package main;

import java.io.*;
import java.util.*;

public class Boj1012 {

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
    StringTokenizer st;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    while (T-- > 0) {
      st = new StringTokenizer(input.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      Queue<Node> que = new LinkedList<>();
      boolean[][] visited = new boolean[n][m];
      int[][] board = new int[n][m];

      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(input.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        board[x][y] = 1;
      }

      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!visited[i][j] && board[i][j] == 1) {
            visited[i][j] = true;
            que.add(new Node(i, j));

            while (!que.isEmpty()) {
              Node cur = que.remove();
              for (int l = 0; l < 4; l++) {
                int nx = cur.x + dx[l];
                int ny = cur.y + dy[l];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                  continue;
                }
                if (visited[nx][ny] || board[nx][ny] == 0) {
                  continue;
                }
                visited[nx][ny] = true;
                que.add(new Node(nx, ny));
              }
            }
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
}
