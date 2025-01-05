package main;

import java.io.*;

public class Boj2577 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());
    int C = Integer.parseInt(br.readLine());
    int sum = A * B * C;

    int[] count = new int[10];
    while (sum >= 1) {
      count[sum % 10]++;
      sum /= 10;
    }

    for (int c : count) {
      System.out.println(c);
    }
  }
}