package main.beakjoon;

import java.io.*;

public class Boj10808 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int[] arr = new int[26];

    for (char s : str.toCharArray()) {
      arr[(int) s - 'a'] += 1;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
