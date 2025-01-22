package main;

import java.io.*;
import java.util.*;

public class Boj1158 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Integer> que = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      que.add(i);
    }

    System.out.print("<");
    while (!que.isEmpty()) {
      for (int j = 0; j < K - 1; j++) {
        que.add(que.remove());
      }
      System.out.print(que.remove());
      if (!que.isEmpty()) {
        System.out.print(", ");
      }
    }
    System.out.print(">");
  }
}
