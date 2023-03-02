package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1218_괄호짝짓기_D4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = in.nextInt();
			char[] arr = in.next().toCharArray();
			// stack : 마지막 넣은 문자로 짝이 맞는지 확인 & 0 확인
			Stack<Character> first = new Stack<>();
			Stack<Character> second = new Stack<>();
			Stack<Character> third = new Stack<>();
			Stack<Character> fourth = new Stack<>();
			for (int i = 0; i < N; i++) {
				if (arr[i] == '(' || arr[i] == ')') {
					first.push(arr[i]);
				}
				if (arr[i] == '[' || arr[i] == ']') {
					second.push(arr[i]);
				}
				if (arr[i] == '{' || arr[i] == '}') {
					third.push(arr[i]);
				}
				if (arr[i] == '<' || arr[i] == '>') {
					fourth.push(arr[i]);
				}
			}
			// 각 스택 확인하기
			Stack<Character>[] stacks = new Stack[] { first, second, third, fourth };
			char[] close = { ')', ']', '}', '>' };
			char[] open = { '(', '[', '{', '<' };

			int answer = 1;
			outer: for (int i = 0; i < 4; i++) { // 네 스택을 다 보기

				if (!stacks[i].isEmpty() && stacks[i].peek() != close[i]) { // 첫순서가 닫힌괄호인지 검사
					answer = 0;
					break; // 안닫혔으면 탈출 후 종료
				}
				if (stacks[i].size() % 2 != 0) {// 스택사이즈가 짝수인지 검사
					answer = 0;
					break;
				}
				int closeNum = (int) stacks[i].stream().filter(s -> s == ')').count();
				int openNum = (int) stacks[i].stream().filter(s -> s == '(').count();
				if (closeNum != openNum) {
					answer = 0;
					break;
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}

//while(!stacks[i].isEmpty()) { //값이 있는동안
//
//if(stacks[i].pop() != close[i]) { //처음 pop이 close여야
//	answer = 0;
//	break outer;
//}
//if(stacks[i].pop() != open[i]) { //두번째 pop은 open이어야 함.
//	answer = 0;
//	break outer;
//}
//}