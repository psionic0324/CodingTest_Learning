package test.beakjoon;

import static main.beakjoon.Basic2.Func;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Basic2Test {

  @DisplayName("Test_1")
  @Test
  public void Test_1() {
    int[] arr = {1, 52, 48};

    int result = Func(arr, arr.length);

    System.out.println("Test_1 output : " + result);
    assertEquals(1, result);
  }

  @DisplayName("Test_2")
  @Test
  public void Test_2() {
    int[] arr = {50, 42};

    int result = Func(arr, arr.length);

    System.out.println("Test_2 output : " + result);
    assertEquals(0, result);
  }

  @DisplayName("Test_3")
  @Test
  public void Test_3() {
    int[] arr = {4, 13, 63, 87};

    int result = Func(arr, arr.length);

    System.out.println("Test_3 output : " + result);
    assertEquals(1, result);
  }
}
