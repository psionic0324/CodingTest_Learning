package main;

import java.io.*;
import java.util.StringTokenizer;

public class Boj3273 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(input.readLine());
    StringTokenizer st = new StringTokenizer(input.readLine());
    int x = Integer.parseInt(input.readLine());

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    boolean[] check = new boolean[2000001];
    for (int i : arr) {
      check[i] = true;
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if ((x - arr[i]) > 0 && check[x - arr[i]]) {
        cnt++;
      }
    }
    System.out.println(cnt / 2);
  }
}