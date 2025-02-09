package main;

import java.io.*;
import java.util.Stack;

public class Boj10799 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String str = input.readLine();
    int stickCnt = 0;
    int result = 0;
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(') {
        if (stack.isEmpty()) {
          stack.push(c);
        } else {
          stickCnt++;
        }
      } else if (c == ')') {
        if (stack.isEmpty()) {
          stickCnt--;
          result++;
        } else {
          result += stickCnt;
          stack.pop();
        }
      }
    }
    System.out.println(result);
  }
}