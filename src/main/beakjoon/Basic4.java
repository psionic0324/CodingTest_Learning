package main.beakjoon;

public class Basic4 {

  public static int Func(int n) {
    int i = 2;
    while (true) {
      if (i > n) {
        return i / 2;
      }
      i *= 2;
    }
  }
}
