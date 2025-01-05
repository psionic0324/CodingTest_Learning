package main.beakjoon;

public class Basic3 {

  public static int Func(int num) {
    for (int i = 1; i < 30000; i++) {
      if (i * i == num) {
        return 1;
      }
    }
    return 0;
  }
}
