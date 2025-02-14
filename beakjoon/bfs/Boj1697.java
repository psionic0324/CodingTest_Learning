package main;

import java.io.*;
import java.util.*;

public class Boj1697 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Queue<Integer> que = new LinkedList<>();
    int[] visit = new int[100001];

    que.add(n);
    visit[n] = 1;
    while (visit[m] == 0) {
      int cur = que.remove();
      for (int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
        if (nx < 0 || nx > 100000) {
          continue;
        }
        if (visit[nx] > 0) {
          continue;
        }
        visit[nx] = visit[cur] + 1;
        que.add(nx);
      }
    }
    System.out.println(visit[m] - 1);
  }
}