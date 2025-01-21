package main;

import java.io.*;

public class Boj1919 {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String a = input.readLine();
    String b = input.readLine();

    int[] count = new int[26];
    for (char c : a.toCharArray()) {
      count[c - 'a']++;
    }
    for (char c : b.toCharArray()) {
      count[c - 'a']--;
    }

    int result = 0;
    for (int n : count) {
      if (n > 0) {
        result += n;
      } else if (n < 0) {
        result -= n;
      }
    }

    System.out.println(result);
  }
}
