package main;

import java.io.*;
import java.util.Stack;

public class Boj2504 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String str = input.readLine();
    int[] arr = new int[30];
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(' || c == '[') {
        stack.push(c);
      } else {
        if (c == ')') {
          if (stack.isEmpty() || stack.peek() != '(') {
            System.out.println(0);
            return;
          } else {
            stack.pop();
            if (arr[stack.size() + 1] == 0) {
              arr[stack.size()] += 2;
            } else {
              arr[stack.size()] += arr[stack.size() + 1] * 2;
              arr[stack.size() + 1] = 0;
            }
          }
        } else {
          if (stack.isEmpty() || stack.peek() != '[') {
            System.out.println(0);
            return;
          } else {
            stack.pop();
            if (arr[stack.size() + 1] == 0) {
              arr[stack.size()] += 3;
            } else {
              arr[stack.size()] += arr[stack.size() + 1] * 3;
              arr[stack.size() + 1] = 0;
            }
          }
        }
      }
    }
    System.out.println(arr[0]);
  }
}
