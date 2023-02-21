package solving_club;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Q1224_계산기3_D4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int m = 1; m <= 10; m++) {
			int T = in.nextInt();
			// 연산자 + 를 넣을 스택 만들기
			Stack<Character> stack = new Stack<>();
			int i = 0;
			char[] line = in.next().toCharArray();

			// map으로 해보기!
			Map<Character, Integer> isp = new HashMap<Character, Integer>();
			isp.put('(', 0);
			isp.put('+', 1);
			isp.put('-', 1);
			isp.put('*', 2);
			isp.put('/', 2);
			Map<Character, Integer> icp = new HashMap<Character, Integer>();
			icp.put(')', 3);
			icp.put('(', 3);
			icp.put('+', 1);
			icp.put('-', 1);
			icp.put('*', 2);
			icp.put('/', 2);
			int parenthesis = 0;

			char[] calculator = new char[T];
			// 중위 -> 후위
			for (int t = 0; t < T; t++) {
				char target = line[t];
				// 만약 숫자이면 calculator에 넣기
				if (Character.isDigit(target)) {
					calculator[i++] = target;

				} else { // 만약 + / *이면 -> 스택이 비어있으면 넣기. 아니면 넣고 스택값 빼서 출력
					if (stack.isEmpty()) {
						stack.push(target);
					} else {
						// 스택에 이미 있는 기호의 isp값 확인
						if (target == ')') {// 닫는 괄호 만나면 여는괄호 만날때까지 pop해주기
							parenthesis+=2;
							while (stack.peek() != '(') {
								calculator[i++] = stack.pop();
							}
							stack.pop(); //여는괄호도 pop
						} else {
							int incoming = icp.get(target); //1
							int instack = isp.get(stack.peek()); //2
							if (incoming > instack) {
								stack.push(target);
							} else if (incoming <= instack) {
								calculator[i++] = stack.pop();
								while (!stack.empty() && stack.peek() != '(' && isp.get(stack.peek()) >= incoming) {
									calculator[i++] = stack.pop();
								}
								stack.push(target);
							}
						}
					}
				}
			} 
			// 스택이 비어있을때까지
			while (!stack.isEmpty()) {
				calculator[i++] = stack.pop();
			}

			Stack<Integer> stack2 = new Stack<>();
			// 후위 -> 중위
			// calculator 값을 하나씩 돌려보면서
			// 숫자이면 스택에 넣고, 연산자이면 계산해서 다시 스택에 넣기
		
			for (int t = 0; t < T-parenthesis; t++) {
				
				if (Character.isDigit(calculator[t])) {
					stack2.push(calculator[t] - '0');

				} else {
					if (calculator[t] == '+') {
						stack2.push(stack2.pop() + stack2.pop());
					} else {
						stack2.push(stack2.pop() * stack2.pop());
					}
				}
			}
			System.out.printf("#%d %d\n", m, stack2.pop());
//			System.out.println(parenthesis);
		}
	}
}
