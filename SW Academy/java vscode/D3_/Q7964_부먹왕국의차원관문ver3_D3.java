import java.util.Arrays;
import java.util.Scanner;

public class Q7964_부먹왕국의차원관문ver3_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt(); // 7
			int[] arr = new int[N]; // 배열에 담기
			int K = in.nextInt(); // 2
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt(); // 0-6
			}
			System.out.println(Arrays.toString(arr));
			int install = 0; // 설치
			// 0 0 0 1 1 0 1 //각각의 인덱스를 보며
			// 처음부터 시작, 최대거리만큼 0을 만나면 그자리에 세워주기.
			// 중간에 1을 만나면 다시 거기서 시작,
			int i = 0;
			int noDoor = 0;
			while (i < N) {// i가 6까지만 돌동안
				if (arr[i] == 0) {
					noDoor++;
				} else if (arr[i] == 1) {
					noDoor = 0;
				}

				if (noDoor == K) {
					install++;
					noDoor = 0;
				}
				i++;
			}

			System.out.printf("#%d %d\n", t, install);
		}
	}
}
