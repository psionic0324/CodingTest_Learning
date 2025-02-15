package main;

import java.util.*;

public class Boj2667 {

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
    int N = Integer.parseInt(in.nextLine());
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] board = new int[N][N];
    boolean[][] visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String s = in.nextLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }

    int count = 0;
    ArrayList<Integer> list = new ArrayList<>();
    Queue<Node> que = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1 && !visited[i][j]) {
          visited[i][j] = true;
          que.add(new Node(i, j));
          int cnt = 1;

          while (!que.isEmpty()) {
            Node cur = que.remove();
            for (int k = 0; k < 4; k++) {
              int nx = cur.x + dx[k];
              int ny = cur.y + dy[k];
              if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
              }
              if (visited[nx][ny] || board[nx][ny] != 1) {
                continue;
              }
              visited[nx][ny] = true;
              que.add(new Node(nx, ny));
              cnt++;
            }
          }
          count++;
          list.add(cnt);
        }
      }
    }
    System.out.println(count);
    Collections.sort(list);
    for (int n : list) {
      System.out.println(n);
    }
  }
}