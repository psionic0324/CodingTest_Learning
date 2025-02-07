package main;

import java.io.*;
import java.util.*;

public class Boj10866 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(input.readLine());
    StringTokenizer st;

    Deque<Integer> deque = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(input.readLine());
      switch (st.nextToken()) {
        case "push_front": {
          deque.addFirst(Integer.parseInt(st.nextToken()));
          break;
        }
        case "push_back": {
          deque.addLast(Integer.parseInt(st.nextToken()));
          break;
        }
        case "pop_front": {
          if (!deque.isEmpty()) {
            sb.append(deque.removeFirst() + "\n");
          } else {
            sb.append("-1" + "\n");
          }
          break;
        }
        case "pop_back": {
          if (!deque.isEmpty()) {
            sb.append(deque.removeLast() + "\n");
          } else {
            sb.append("-1" + "\n");
          }
          break;
        }
        case "size": {
          sb.append(deque.size() + "\n");
          break;
        }
        case "empty": {
          if (!deque.isEmpty()) {
            sb.append("0" + "\n");
          } else {
            sb.append("1" + "\n");
          }
          break;
        }
        case "front": {
          if (!deque.isEmpty()) {
            sb.append(deque.getFirst() + "\n");
          } else {
            sb.append("-1" + "\n");
          }
          break;
        }
        case "back": {
          if (!deque.isEmpty()) {
            sb.append(deque.getLast() + "\n");
          } else {
            sb.append("-1" + "\n");
          }
          break;
        }
      }
    }
    System.out.println(sb.toString().trim());
  }
}