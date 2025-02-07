package main;

import java.io.*;
import java.util.*;

public class Boj2164 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      queue.add(i);
    }

    while (queue.size() > 1) {
      queue.remove();
      queue.add(queue.remove());
    }
    System.out.println(queue.remove());
  }
}