package main;

import java.io.*;
import java.util.*;

public class Boj7562 {

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
    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    while (T-- > 0) {
      int l = Integer.parseInt(input.readLine());
      int[][] visited = new int[l][l];
      StringTokenizer st = new StringTokenizer(input.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      Queue<Node> que = new LinkedList<>();

      for (int i = 0; i < l; i++) {
        Arrays.fill(visited[i], -1);
      }
      visited[x][y] = 0;
      que.add(new Node(x, y));
      while (!que.isEmpty()) {
        Node cur = que.remove();
        for (int i = 0; i < 8; i++) {
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
            continue;
          }
          if (visited[nx][ny] >= 0) {
            continue;
          }
          visited[nx][ny] = visited[cur.x][cur.y] + 1;
          que.add(new Node(nx, ny));
        }
      }
      st = new StringTokenizer(input.readLine());
      int tx = Integer.parseInt(st.nextToken());
      int ty = Integer.parseInt(st.nextToken());
      System.out.println(visited[tx][ty]);
    }
  }
}