package main;

import java.io.*;
import java.util.Stack;

public class Boj10773 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(input.readLine());
    int num;

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < K; i++) {
      num = Integer.parseInt(input.readLine());
      if (num == 0) {
        stack.pop();
      } else {
        stack.push(num);
      }
    }

    int sum = 0;
    for (int n : stack) {
      sum += n;
    }
    System.out.println(sum);
  }
}