package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1222_계산기1_D4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int m = 1; m <= 10; m++) {
			int T = in.nextInt();
			// 연산자 + 를 넣을 스택 만들기
			Stack<Character> stack = new Stack<>();
			int i = 0;
			char[] line = in.next().toCharArray();
			char[] calculator = new char[T];
			// 중위 -> 후위
			for (int t = 0; t < T; t++) {
				char target = line[t];
				// 만약 다음 수가 +가 아니면 프린트하기
				if (target != '+') {
					calculator[i++] = target;

				} else { // 만약 +이면 -> 스택이 비어있으면 넣기. 아니면 넣고 스택값 빼서 출력
					if (stack.isEmpty())
						stack.push(target);
					else {
						calculator[i++] = stack.pop();
						stack.push(target);
					}
				}
			}
			//스택이 비어있을때까지
			if (!stack.isEmpty()) {
				calculator[i] = stack.pop();
			}

			Stack<Integer> stack2 = new Stack<>();
			// 후위 -> 중위
//		calculator 값을 하나씩 돌려보면서
//		숫자이면 스택에 넣고, 연산자이면 계산해서 다시 스택에 넣기
			for (int t = 0; t < T; t++) {
				if (Character.isDigit(calculator[t])) {
					stack2.push(calculator[t] - '0');

				} else {
					stack2.push(stack2.pop() + stack2.pop());
				}
			}

			System.out.printf("#%d %d\n", m, stack2.pop());
		}

	}
}
