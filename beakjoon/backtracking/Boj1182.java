package main;

import java.io.*;
import java.util.*;

public class Boj1182 {

  static int n, s;
  static int[] arr = new int[30];
  static int cnt = 0;

  static void func(int cur, int sum) {
    if (cur == n) {
      if (sum == s) {
        cnt++;
      }
      return;
    }
    func(cur + 1, sum);
    func(cur + 1, sum + arr[cur]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    func(0, 0);
    if (s == 0) {
      cnt--;
    }
    System.out.println(cnt);
  }
}