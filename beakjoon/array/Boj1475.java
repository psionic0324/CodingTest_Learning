package main;

import java.io.*;

public class Boj1475 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    int[] count = new int[10];

    while (num >= 1) {
      count[num % 10]++;
      num /= 10;
    }

    int max = 0;
    for (int i = 0; i < 10; i++) {
      if (i == 6 || i == 9) {
        continue;
      }
      max = Math.max(count[i], max);
    }

    max = Math.max((count[6] + count[9] + 1) / 2, max);
    System.out.println(max);
  }
}
