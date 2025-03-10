package main;

import java.util.Scanner;

public class Boj17478 {

  static void out(String s, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print("____");
    }
    System.out.println(s);
  }

  static void func(int n, int cnt) {
    out("\"재귀함수가 뭔가요?\"", cnt);
    if (cnt == n) {
      out("\"재귀함수는 자기 자신을 호출하는 함수라네\"", cnt);
    } else {
      out("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", cnt);
      out("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", cnt);
      out("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"", cnt);
      func(n, cnt + 1);
    }
    out("라고 답변하였지.", cnt);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
    func(n, 0);
  }
}
