package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q7102_준홍이의카드놀이_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = in.nextInt();
			int M = in.nextInt();
			System.out.print("#" + t + " ");
			int[] arr = new int[N + M + 1];
			int max = 0;
			// 각 카드의 숫자를 하나씩 올려가며 모두 더하기! 브루트포스
			// 연산과 카운팅소트
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i + j]++;
					if (max < arr[i + j])
						max = arr[i + j];
				}
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
