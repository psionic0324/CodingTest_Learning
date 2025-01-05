package test.simulation;

import static main.simulation.KiwiJuice.thePouring;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KiwiJuiceTest {
    @DisplayName("Test_1")
    @Test
    void Test_1() {
        int[] capacities = {20, 20};
        int[] bottles = {5, 8};
        int[] fromId = {0};
        int[] toId = {1};
        int[] Returns = {0, 13};

        int[] myReturns = thePouring(capacities, bottles, fromId, toId);

        System.out.println("Test_1 : " + Arrays.toString(myReturns));
        assertArrayEquals(Returns, myReturns);
    }

    @DisplayName("Test_2")
    @Test
    void Test_2() {
        int[] capacities = {10, 10};
        int[] bottles = {5, 8};
        int[] fromId = {0};
        int[] toId = {1};
        int[] Returns = {3, 10};

        int[] myReturns = thePouring(capacities, bottles, fromId, toId);

        System.out.println("Test_2 : " + Arrays.toString(myReturns));
        assertArrayEquals(Returns, myReturns);
    }

    @DisplayName("Test_3")
    @Test
    void Test_3() {
        int[] capacities = {30, 20, 10};
        int[] bottles = {10, 5, 5};
        int[] fromId = {0, 1, 2};
        int[] toId = {1, 2, 0};
        int[] Returns = {10, 10, 0};

        int[] myReturns = thePouring(capacities, bottles, fromId, toId);

        System.out.println("Test_3 : " + Arrays.toString(myReturns));
        assertArrayEquals(Returns, myReturns);
    }

    @DisplayName("Test_4")
    @Test
    void Test_4() {
        int[] capacities = {14, 35, 86, 58, 25, 62};
        int[] bottles = {6, 34, 27, 38, 9, 60};
        int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
        int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};
        int[] returns = {0, 14, 65, 35, 25, 35};

        int[] myReturns = thePouring(capacities, bottles, fromId, toId);

        System.out.println("Test_4 : " + Arrays.toString(myReturns));
        assertArrayEquals(returns, myReturns);
    }

    @DisplayName("Test_5")
    @Test
    void Test_5() {
        int[] capacities = {700000, 800000, 900000, 1000000};
        int[] bottles = {478478, 478478, 478478, 478478};
        int[] fromId = {2, 3, 2, 0, 1};
        int[] toId = {0, 1, 1, 3, 2};
        int[] Returns = {0, 156956, 900000, 856956};

        int[] myReturns = thePouring(capacities, bottles, fromId, toId);

        System.out.println("Test_5 : " + Arrays.toString(myReturns));
        assertArrayEquals(Returns, myReturns);
    }
}