package main;

import java.util.*;

public class Boj2468 {

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
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int N = in.nextInt();
    int[][] board = new int[N][N];
    int maxNum = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = in.nextInt();
        if (maxNum < board[i][j]) {
          maxNum = board[i][j];
        }
      }
    }

    Queue<Node> que = new LinkedList<>();
    int maxCount = 0;
    for (int k = 0; k <= maxNum; k++) {
      boolean[][] visited = new boolean[N][N];

      int count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && board[i][j] > k) {
            visited[i][j] = true;
            que.add(new Node(i, j));

            while (!que.isEmpty()) {
              Node cur = que.remove();
              for (int l = 0; l < 4; l++) {
                int nx = cur.x + dx[l];
                int ny = cur.y + dy[l];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                  continue;
                }
                if (visited[nx][ny] || board[nx][ny] <= k) {
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
      if (maxCount < count) {
        maxCount = count;
      }
    }
    System.out.println(maxCount);
  }
}