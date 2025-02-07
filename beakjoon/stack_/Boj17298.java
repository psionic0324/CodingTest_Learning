package main;

import java.io.*;
import java.util.*;

public class Boj17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    StringTokenizer st = new StringTokenizer(input.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>();
    int[] result = new int[N];
    for (int i = N - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] >= stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = -1;
      } else {
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int n : result) {
      sb.append(n).append(" ");
    }
    System.out.println(sb.toString().trim());
  }
}