package main;

/*
 * 시간 제한 1.5초, 입력 데이터 최대 500,000개 -> 최대 O(NlongN)
 * 메모리 제한 128 mb
 */

import java.io.*;
import java.util.*;

public class Boj2493 {

  static class Tower {

    int height, index;

    Tower(int height, int index) {
      this.height = height;
      this.index = index;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Tower> stack = new Stack<>();

    for (int i = 1; i <= N; i++) {
      int height = Integer.parseInt(st.nextToken());
      while (!stack.isEmpty() && height > stack.peek().height) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        sb.append("0 ");
      } else {
        sb.append(stack.peek().index + " ");
      }
      stack.push(new Tower(height, i));
    }

    System.out.println(sb.toString().trim());
  }
}