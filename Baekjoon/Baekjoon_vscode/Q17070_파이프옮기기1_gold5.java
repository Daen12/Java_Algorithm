import java.util.Arrays;
import java.util.Scanner;

public class Q17070_파이프옮기기1_gold5 {
	// 1,1에서 시작해서
	// 가로, 세로, 대각선에 대해 재귀함수 만들기
	// 종료 조건 : 가로나 세로가 N에 도달하면!
	// 둘다 N,N이면 카운트 업 해주기
	// 초기화 실수 하지말기ㅠㅠ
	static int count;
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		map = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = in.nextInt();
			}
		}
		int R = 1;
		int C = 2;
		count = 0;

		backTracking(R, C, 1);
		System.out.println(count);

	}

	public static void backTracking(int R, int C, int dir) {

		if (R == N && C == N) { // 둘다 N인 경우 카운트 업 해주고 함수 종료
			count++;
			return;
		}

		// 가로/대각선
		if (dir == 1 || dir == 3) {
			if ((C + 1 <= N) && (map[R][C + 1] == 0)) {
				backTracking(R, C + 1, 1);// 가로
			}
		}

		// 세로/대각선
		if (dir == 2 || dir == 3) {
			if (R + 1 <= N && map[R + 1][C] == 0) {
				backTracking(R + 1, C, 2);
			}
		}
		// 대각선(디폴트)
		if (C + 1 <= N && R + 1 <= N) {
			if (map[R + 1][C + 1] == 0 && map[R + 1][C] == 0 && map[R][C + 1] == 0) {
				backTracking(R + 1, C + 1, 3);
			}
		}
	}
}