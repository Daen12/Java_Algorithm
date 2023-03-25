import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q15664_N과M11_silver2 {
	// 순열인데 M개를 뽑는것
	// isUsed사용X
	// 인자로 인덱스 받지 않음.
	static int N, M;
	static int[] nums;
	static Stack<Integer> stack;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = in.nextInt();
		}
		Arrays.sort(nums);
		stack = new Stack<>();
		Permutation(0);
		System.out.println(sb);
	}

	private static void Permutation(int depth) {
		int lastNum = -1;
		if (depth == M) {
			for (int i : stack) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (nums[i] != lastNum) {// 사용되지 않았으면
				// 마지막 숫자가 현재 들어갈 숫자가 아니면
				stack.push(nums[i]);
				lastNum = nums[i];
				Permutation(depth + 1);
				stack.pop();

			}
		}
	}
}
