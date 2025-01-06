package main;

import java.io.*;
import java.util.StringTokenizer;

public class Boj10807 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(input.readLine());
    StringTokenizer st = new StringTokenizer(input.readLine());
    int v = Integer.parseInt(input.readLine());

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (v == Integer.parseInt(st.nextToken())) {
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}