package main;

import java.io.*;
import java.util.*;

public class Boj4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(input.readLine(), "()[]", true);
      if (st.countTokens() == 1 && st.nextToken().equals(".")) {
        break;
      }

      Stack<String> stack = new Stack<>();
      boolean isRight = true;
      while (st.countTokens() > 0) {
        String s = st.nextToken();
        if (s.equals("(") || s.equals("[")) {
          stack.push(s);
        } else if (s.equals(")")) {
          if (stack.empty() || !stack.peek().equals("(")) {
            isRight = false;
            break;
          }
          stack.pop();
        } else if (s.equals("]")) {
          if (stack.empty() || !stack.peek().equals("[")) {
            isRight = false;
            break;
          }
          stack.pop();
        }
      }

      if (!stack.isEmpty()) {
        isRight = false;
      }
      if (isRight) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }
}