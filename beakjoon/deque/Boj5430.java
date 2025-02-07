package main;

import java.io.*;
import java.util.*;

public class Boj5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(input.readLine());
    StringTokenizer st;

    while (T-- > 0) {
      String command = input.readLine();
      int n = Integer.parseInt(input.readLine());
      st = new StringTokenizer(input.readLine(), "[],");

      Deque<Integer> deque = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        deque.add(Integer.parseInt(st.nextToken()));
      }

      boolean isReversed = false;
      boolean isError = false;
      for (int i = 0; i < command.length(); i++) {
        char c = command.charAt(i);
        if (c == 'R') {
          isReversed = !isReversed;
        } else if (c == 'D') {
          if (deque.isEmpty()) {
            isError = true;
            break;
          }
          if (isReversed) {
            deque.removeLast();
          } else {
            deque.removeFirst();
          }
        }
      }

      if (isError) {
        sb.append("error\n");
      } else {
        sb.append("[");
        if (!deque.isEmpty()) {
          if (!isReversed) {
            sb.append(deque.removeFirst());
            while (!deque.isEmpty()) {
              sb.append(",").append(deque.removeFirst());
            }
          } else {
            sb.append(deque.removeLast());
            while (!deque.isEmpty()) {
              sb.append(",").append(deque.removeLast());
            }
          }
        }
        sb.append("]").append("\n");
      }
    }
    System.out.println(sb);
  }
}
