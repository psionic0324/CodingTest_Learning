package main;

import java.io.*;
import java.util.*;

public class Boj5397 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(input.readLine());

    for (int i = 0; i < n; i++) {
      Stack<Character> leftStack = new Stack<>();
      Stack<Character> rightStack = new Stack<>();

      String s = input.readLine();
      for (char c : s.toCharArray()) {
        switch (c) {
          case '<': {
            if (!leftStack.isEmpty()) {
              rightStack.push(leftStack.pop());
            }
            break;
          }
          case '>': {
            if (!rightStack.isEmpty()) {
              leftStack.push(rightStack.pop());
            }
            break;
          }
          case '-': {
            if (!leftStack.isEmpty()) {
              leftStack.pop();
            }
            break;
          }
          default:
            leftStack.push(c);
            break;
        }
      }
      while (!leftStack.isEmpty()) {
        rightStack.push(leftStack.pop());
      }
      while (!rightStack.isEmpty()) {
        output.write(rightStack.pop());
      }
      output.write("\n");
    }
    output.flush();
    output.close();
    input.close();
  }
}