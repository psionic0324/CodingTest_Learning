package main;

import java.io.*;
import java.util.*;

public class Boj9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(input.readLine());

    while (T-- > 0) {
      String str = input.readLine();
      Stack<Character> stack = new Stack<>();
      boolean isRight = true;

      for (int i = 0; i < str.length(); i++) {
        char s = str.charAt(i);
        if (s == '(') {
          stack.push(s);
        } else if (s == ')') {
          if (stack.isEmpty()) {
            isRight = false;
            break;
          } else if (stack.peek() != '(') {
            isRight = false;
            break;
          } else {
            stack.pop();
          }
        }
      }
      if (!stack.isEmpty()) {
        isRight = false;
      }

      if (isRight) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}