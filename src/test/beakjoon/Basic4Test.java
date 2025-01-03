package test.beakjoon;

import static main.beakjoon.Basic4.Func;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Basic4Test {

  @DisplayName("Test_1")
  @Test
  public void Test_1() {
    int num = 5;

    int result = Func(num);

    System.out.println("Test_1 output : " + result);
    assertEquals(4, result);
  }

  @DisplayName("Test_2")
  @Test
  public void Test_2() {
    int num = 97615282;

    int result = Func(num);

    System.out.println("Test_2 output : " + Func(num));
    assertEquals(67108864, Func(num));
  }

  @DisplayName("Test_3")
  @Test
  public void Test_3() {
    int num = 1024;

    int result = Func(num);

    System.out.println("Test_3 output : " + result);
    assertEquals(1024, result);
  }
}