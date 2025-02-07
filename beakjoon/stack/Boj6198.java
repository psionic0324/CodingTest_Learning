package main;

/*
 * 시간 제한 1초, 입력 데이터 최대 80,000개 -> 최대 O(NlongN)
 * 높이가 10억 단위이므로 합산할 때 long 사용
 * */

import java.io.*;
import java.util.*;

public class Boj6198 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    long sum = 0;
    for (int i = 0; i < N; i++) {
      int height = Integer.parseInt(br.readLine());
      while (!stack.isEmpty() && height >= stack.peek()) {
        stack.pop();
      }
      sum += stack.size();
      stack.push(height);
    }
    System.out.println(sum);
  }
}