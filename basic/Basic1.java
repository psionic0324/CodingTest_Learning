package main.beakjoon;

public class Basic1 {

  public static int Func(int num) {
    int sum = 0;
    for (int i = 1; i <= num; i++) {
      if (i % 3 == 0) {
        sum += i;
      } else if (i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }
}
