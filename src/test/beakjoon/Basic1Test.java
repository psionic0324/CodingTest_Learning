package test.beakjoon;

import static main.beakjoon.Basic1.Func;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Basic1Test {

  @DisplayName("Test_1")
  @Test
  public void Test_1() {
    int num = 16;

    System.out.println("Test_1 output : " + Func(num));
    assertEquals(60, Func(num));
  }

  @DisplayName("Test_2")
  @Test
  public void Test_2() {
    int num = 34567;

    System.out.println("Test_2 output : " + Func(num));
    assertEquals(278812814, Func(num));
  }

  @DisplayName("Test_3")
  @Test
  public void Test_3() {
    int num = 27639;

    System.out.println("Test_3 output : " + Func(num));
    assertEquals(178254968, Func(num));
  }
}