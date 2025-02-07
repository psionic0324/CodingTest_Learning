package main;

import java.io.*;
import java.util.*;

public class Boj1021 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }

    int sum = 0;
    st = new StringTokenizer(input.readLine());
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      int count = 0;
      while (deque.peek() != target) {
        deque.add(deque.remove());
        count++;
      }
      sum += Math.min(count, deque.size() - count);
      deque.remove();
    }
    System.out.println(sum);
  }
}