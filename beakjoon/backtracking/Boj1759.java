package main;

import java.util.*;

public class Boj1759 {

  static int L, C;
  static String[] arr = new String[30];
  static int[] answer = new int[30];
  static StringBuilder sb = new StringBuilder();

  static boolean isVowel(String s) {
    return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
  }

  static void func(int cur, int start) {
    if (cur == L) {
      int cnt1 = 0;
      int cnt2 = 0;
      for (int i = 0; i < L; i++) {
        if (isVowel(arr[answer[i]])) {
          cnt1++;
        } else {
          cnt2++;
        }
      }
      if (cnt1 >= 1 && cnt2 >= 2) {
        for (int i = 0; i < L; i++) {
          sb.append(arr[answer[i]]);
        }
        sb.append("\n");
        return;
      }
    }

    for (int i = start; i < C; i++) {
      answer[cur] = i;
      func(cur + 1, i + 1);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    L = in.nextInt();
    C = in.nextInt();
    in.nextLine();
    String[] s = in.nextLine().split(" ");
    for (int i = 0; i < C; i++) {
      arr[i] = s[i];
    }
    Arrays.sort(arr, 0, C);
    func(0, 0);
    System.out.println(sb);
  }
}