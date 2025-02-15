package main;

import java.util.*;

public class Boj2583 {

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[][] board = new int[n][m];
    boolean[][] visited = new boolean[n][m];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    Queue<Node> que = new LinkedList<>();

    while (k-- > 0) {
      int lx = in.nextInt();
      int ly = in.nextInt();
      int rx = in.nextInt();
      int ry = in.nextInt();
      for (int i = ly; i < ry; i++) {
        for (int j = lx; j < rx; j++) {
          board[i][j] = -1;
        }
      }
    }

    int count = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != -1 && !visited[i][j]) {
          visited[i][j] = true;
          que.add(new Node(i, j));

          int cnt = 1;
          while (!que.isEmpty()) {
            Node cur = que.remove();
            for (int l = 0; l < 4; l++) {
              int nx = cur.x + dx[l];
              int ny = cur.y + dy[l];
              if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
              }
              if (visited[nx][ny] || board[nx][ny] == -1) {
                continue;
              }
              visited[nx][ny] = true;
              que.add(new Node(nx, ny));
              cnt++;
            }
          }
          list.add(cnt);
          count++;
        }
      }
    }

    Collections.sort(list);
    System.out.println(count);
    for (int i = 0; i < count; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}