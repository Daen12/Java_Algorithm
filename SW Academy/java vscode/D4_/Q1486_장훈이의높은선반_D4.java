package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1486_장훈이의높은선반_D4 {
	// 직원들의 키 powerset으로 구한후 더하기
	// 이 값이 B보다 큰지 확인
	// 만약 크면 기존의 값보다 작은지 확인
	// 작으면 그걸로 정답 갱신

	static int[] heights;
	static int B;
	static int N;
	static int result;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();
			B = in.nextInt();
			result = Integer.MAX_VALUE;
			heights = new int[N];
			for (int i = 0; i < N; i++) {
				heights[i] = in.nextInt();
			}
			stack = new Stack<>();
			powerSet(0);
			System.out.printf("#%d %d\n", t, result - B);
		}
	}

	public static void powerSet(int depth) {
		// result = B이면 아예 함수 종료하고싶음. 어케함
		if (result == B) {
			return;
		}

		if (depth == N) { // 직원들 골랐으면 고른 키가 스택에 들어있음.
//			System.out.println(stack);
			int sum = 0;
			for (int i : stack) {
				sum += i;
			}
			if (sum >= B) {
				result = result > sum ? sum : result;
			}
			return;
		}
		stack.push(heights[depth]);
		powerSet(depth + 1);
		stack.pop();
		powerSet(depth + 1); // 건너뛰고 다음꺼
		// 스택을 안쓰면??
	}
}
