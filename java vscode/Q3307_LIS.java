
import java.util.Arrays;
import java.util.Scanner;

public class Q3307_LIS {
	// Revision - version. LIS
	// 출처 구글링
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int t = 0; t < T; t++) {
			// 여기서부터 연산 시작

			int n = in.nextInt();
			int[] array = new int[n];
			// array 배열에 수열 넣어주기.
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}

			// array와 길이가 같은 배열 하나 생성 > for루프 돌면서
			int[] table = new int[n];
			for (int i = 0; i < n; i++) {
				// 생성된 배열의 i번째 값은 1로 초기화
				table[i] = 1;
				for (int j = 0; j < i; j++) {
					// i번째 값을 기준으로 처음부터 돌면서 비교. 만약 해당값이 i번째 값보다 작으면,
					if (array[j] < array[i]) {
						// i번째 값 = 작은값들 중 가장 큰 값 + 1
						table[i] = Math.max(table[i], table[j] + 1);
					}
				}
			}
			Arrays.sort(table);
			System.out.println("#" + (t + 1) + " " + table[n - 1]);
			// 이중 for문으로 연산하기 때문에 시간복잡도는 O(N^2)

		}
	}
}
