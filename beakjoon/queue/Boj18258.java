package main;

import java.io.*;
import java.util.*;

public class Boj18258 {

  static int[] queue = new int[2000001];
  static int head = 0;
  static int tail = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(input.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(input.readLine());
      switch (st.nextToken()) {
        case "push": {
          queue[tail++] = Integer.parseInt(st.nextToken());
          break;
        }
        case "pop": {
          if (tail <= head) {
            output.write(String.valueOf(-1) + "\n");
          } else {
            output.write(String.valueOf(queue[head++]) + "\n");
          }
          break;
        }
        case "size": {
          output.write(String.valueOf(tail - head) + "\n");
          break;
        }
        case "empty": {
          if (tail <= head) {
            output.write(String.valueOf(1) + "\n");
          } else {
            output.write(String.valueOf(0) + "\n");
          }
          break;
        }
        case "front": {
          if (tail <= head) {
            output.write(String.valueOf(-1) + "\n");
          } else {
            output.write(String.valueOf(queue[head]) + "\n");
          }
          break;
        }
        case "back": {
          if (tail <= head) {
            output.write(String.valueOf(-1) + "\n");
          } else {
            output.write(String.valueOf(queue[tail - 1]) + "\n");
          }
          break;
        }
      }
    }
    output.flush();
    output.close();
  }
}