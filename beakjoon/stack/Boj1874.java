package main;

import java.io.*;
import java.util.*;

public class Boj1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    int num;

    Stack<Integer> stack = new Stack<>();
    Queue<String> result = new LinkedList<>();
    int top = 0;
    while (n-- > 0) {
      num = Integer.parseInt(input.readLine());
      while (top < num) {
        stack.push(++top);
        result.add("+");
      }
      if (stack.peek() != num) {
        System.out.println("NO");
        System.exit(0);
      }
      stack.pop();
      result.add("-");
    }
    for (String s : result) {
      System.out.println(s);
    }
  }
}