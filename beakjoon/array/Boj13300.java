package main;

import java.io.*;
import java.util.StringTokenizer;

public class Boj13300 {

  static int N, K, gender, grade, room = 0;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(input.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new int[2][7];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(input.readLine());
      gender = Integer.parseInt(st.nextToken());
      grade = Integer.parseInt(st.nextToken());
      arr[gender][grade] += 1;
    }

    for (int i = 0; i < 2; i++) {
      for (int j = 1; j < 7; j++) {
        room += arr[i][j] / K;
        if (arr[i][j] % K != 0) {
          room += 1;
        }
      }
    }
    System.out.print(room);
  }
}