package main;

import java.io.*;
import java.util.*;

public class Boj3986 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());

    int count = 0;
    while (N-- > 0) {
      String str = input.readLine();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < str.length(); i++) {
        char s = str.charAt(i);
        if (s == 'A') {
          if (stack.isEmpty()) {
            stack.push(s);
          } else if (stack.peek() != s) {
            stack.push(s);
          } else {
            stack.pop();
          }
        } else if (s == 'B') {
          if (stack.isEmpty()) {
            stack.push(s);
          } else if (stack.peek() != s) {
            stack.push(s);
          } else {
            stack.pop();
          }
        }
      }
      if (stack.isEmpty()) {
        count++;
      }
    }
    System.out.println(count);
  }
}