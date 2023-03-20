import java.util.Scanner;

public class Q15649_N과M1_silver3 {
	static int N = 0, M = 0; // 4 3
	static int[] arr; // M개의 수를 고르자 (바구니)
	static boolean[] isUsed;// 0인덱스는 사용하지 않음.

	public static void main(String[] args) {
		// https://st-lab.tistory.com/114
		Scanner in = new Scanner(System.in);
		N = in.nextInt();// 4
		M = in.nextInt();// 3
		arr = new int[M];
		isUsed = new boolean[N + 1];

		// 순서가 다르면 다른 세트
		backTracking(0);
	}

	public static void backTracking(int k) {
		if (k == M) { // 만약 깊이가 M에 도달했으면 배열 다 찼다는 뜻이므로 리턴.
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!isUsed[i]) { // i=1부터 N까지
				arr[k] = i;
				isUsed[i] = true;
				backTracking(k + 1);
				isUsed[i] = false;
			}
		}
	}
}
