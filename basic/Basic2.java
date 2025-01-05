package main.beakjoon;

public class Basic2 {

//  public static int Func(int[] arr, int n) {
//    for (int i = 0; i < n; i++) {
//      for (int j = i + 1; j < n; j++) {
//        if (arr[i] + arr[j] == 100) {
//          return 1;
//        }
//      }
//    }
//    return 0;
//  }

  public static int Func(int[] arr, int n) {
    boolean[] check = new boolean[101];
    for (int num : arr) {
      if (check[100 - num]) {
        return 1;
      }
      check[num] = true;
    }
    return 0;
  }

}
