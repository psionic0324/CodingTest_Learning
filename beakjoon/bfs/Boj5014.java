package main;

import java.util.*;

public class Boj5014 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int F = in.nextInt(), S = in.nextInt(), G = in.nextInt();
    int U = in.nextInt(), D = in.nextInt();
    int[] board = new int[F + 1];
    Arrays.fill(board, -1);
    Queue<Integer> que = new LinkedList<>();

    board[S] = 0;
    que.add(S);
    while (!que.isEmpty()) {
      int cur = que.remove();
      for (int i : new int[]{U, -D}) {
        int nx = cur + i;
        if (nx < 1 || nx > F) {
          continue;
        }
        if (board[nx] != -1) {
          continue;
        }
        board[nx] = board[cur] + 1;
        que.add(nx);
      }
    }

    if (board[G] == -1) {
      System.out.println("use the stairs");
    } else {
      System.out.println(board[G]);
    }
  }
}