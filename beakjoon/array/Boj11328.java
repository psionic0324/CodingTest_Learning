package main;

import java.io.*;
import java.util.StringTokenizer;

public class Boj11328 {

  static StringTokenizer st;
  static int N;
  static String a, b;

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(input.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(input.readLine());
      a = st.nextToken();
      b = st.nextToken();

      int[] count = new int[26];
      for (int j = 0; j < a.length(); j++) {
        count[a.charAt(j) - 'a'] += 1;
      }
      for (int j = 0; j < b.length(); j++) {
        count[b.charAt(j) - 'a'] -= 1;
      }

      boolean possible = true;
      for (int j : count) {
        if (j != 0) {
          possible = false;
          break;
        }
      }

      if (possible) {
        System.out.println("Possible");
      } else {
        System.out.println("Impossible");
      }
    }
  }
}