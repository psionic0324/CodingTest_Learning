package main.simulation;

public class KiwiJuice {
    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i++) {
            int from = fromId[i];
            int to = toId[i];
            int toIdEmptySpace = capacities[to] - bottles[to];
            int remainingAmount = toIdEmptySpace - bottles[from];

            if (remainingAmount >= 0) {
                bottles[to] += bottles[from];
                bottles[from] = 0;
            } else {
              bottles[to] = capacities[to];
              bottles[from] = Math.abs(remainingAmount);
            }
        }
        return bottles;
    }

//    public static int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
//        for (int i = 0; i < fromId.length; i++) {
//            int from = fromId[i];
//            int to = toId[i];
//
//            int vol = Math.min(bottles[from], capacities[to] - bottles[to]);
//
//            bottles[from] -= vol;
//            bottles[to] += vol;
//        }
//        return bottles;
//    }
//
//    public static int[] thePouring3(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
//        for (int i = 0; i < fromId.length; i++) {
//            int from = fromId[i];
//            int to = toId[i];
//
//            int sum = bottles[from] + bottles[to];
//
//            bottles[to] = Math.min(sum, capacities[to]);
//            bottles[from] = sum - bottles[to];
//        }
//        return bottles;
//    }
}
