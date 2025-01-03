package test.beakjoon;

import static main.beakjoon.Basic3.Func;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Basic3Test {

  @DisplayName("Test_1")
  @Test
  public void Test_1() {
    int num = 9;

    int result = Func(num);

    System.out.println("Test_1 output : " + result);
    assertEquals(1, result);
  }

  @DisplayName("Test_2")
  @Test
  public void Test_2() {
    int num = 693953651;

    int result = Func(num);

    System.out.println("Test_2 output : " + Func(num));
    assertEquals(0, Func(num));
  }

  @DisplayName("Test_3")
  @Test
  public void Test_3() {
    int num = 756580036;

    int result = Func(num);

    System.out.println("Test_3 output : " + result);
    assertEquals(1, result);
  }
}