import java.util.Arrays;
import java.util.Scanner;

public class Q7964_부먹왕국의차원관문_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt(); // 6
			int[] arr = new int[N + 2]; // 배열에 담기
			int K = in.nextInt(); // 2
			for (int i = 0; i < N + 2; i++) {
				if (i == 0) {
					arr[i] = 1;
				} else if (i == N + 1) {
					arr[i] = 1;
				} else {
					arr[i] = in.nextInt();
				}
			}
			// 앞에서부터 1이 있으면 그자리에서 앞뒤로 k개씩 점프점프 ? 그리디??
			// 앞뒤로 1이 있는 배열 생성
			// 1 1 0 0 0 0 1 1 //7
			int[] array = new int[N + 1];
			for (int i = 1; i < N + 2; i++) { // i는 7까지!
				int k = K; // 2
				int add = 0;
				if (arr[i] == 0) { // 본인이 0이면 add
					add++;
				}
				while (k < N + 2) {
					if (i + k < N + 2 && arr[i + k] == 0) {
						add++;
					}
					if (i - k >= 0 && arr[i - k] == 0) {
						add++;
					}
					k += K;
				}
				array[i - 1] = add;
			}
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			System.out.printf("#%d %d\n", t, array[0]);
		}
	}
}
