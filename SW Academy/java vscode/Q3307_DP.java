
import java.util.Arrays;
import java.util.Scanner;

public class Q3307_DP {
	// Revision - version. DP(Dynamic Programming)
	// DP는 이분탐색을 이용하는 것. 앞선 LIS는 모든 원소를 탐색해야 했기에 보다 효율적인 계산이 요구됨.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int t = 0; t < T; t++) {
			// 여기서부터 연산 시작

			int n = in.nextInt();
			int[] array = new int[n];
			// array 배열에 수열 넣어주기
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}

			// 배열을 새로 생성한 후, 처음부터 for루프 돌면서 해당 값이 저장된 새 배열의 값들 중 가장 작은 값의 위치와 원소를 교환한다
		}
	}
}
