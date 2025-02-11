package main;

import java.io.*;
import java.util.*;

public class Boj4179 {

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
    String[] arr = input.readLine().split(" ");
    int n = Integer.parseInt(arr[0]);
    int m = Integer.parseInt(arr[1]);

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    char[][] board = new char[n][m];
    int[][] visited = new int[n][m];
    int[][] fire = new int[n][m];
    Queue<Node> queJ = new LinkedList<>();
    Queue<Node> queF = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      String s = input.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j);
        if (board[i][j] == 'J') {
          queJ.add(new Node(i, j));
          visited[i][j] = 1;
        } else if (board[i][j] == 'F') {
          queF.add(new Node(i, j));
          fire[i][j] = 1;
        }
      }
    }

    while (!queF.isEmpty()) {
      Node cur = queF.remove();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (fire[nx][ny] > 0 || board[nx][ny] == '#') {
          continue;
        }
        fire[nx][ny] = fire[cur.x][cur.y] + 1;
        queF.add(new Node(nx, ny));
      }
    }

    while (!queJ.isEmpty()) {
      Node cur = queJ.remove();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          System.out.println(visited[cur.x][cur.y]);
          return;
        }
        if (visited[nx][ny] > 0 || board[nx][ny] == '#') {
          continue;
        }
        if (fire[nx][ny] != 0 && visited[cur.x][cur.y] + 1 >= fire[nx][ny]) {
          continue;
        }
        visited[nx][ny] = visited[cur.x][cur.y] + 1;
        queJ.add(new Node(nx, ny));
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
