package solving_club;

import java.util.Scanner;

public class Q5650_핀볼게임_D4 {
	// 1.벽을 만나면 반대방향으로 돌아옴
	// 2.웜홀에 빠지며 동일한 숫자를 가진 다른 웜홀로 나옴
	// 3.출발위치로 돌아오거나 블랙홀에 빠질때 게임 오버
	// 4.총 점수는 벽이나 블록에 부딪힌 횟수.
	static int[][] map;
	static int N;
	static int br, bc, sr, sc;
	static int score, maxScore;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();
			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.nextInt();
				}
			}
			// 점수 초기화 후 모든 인덱스에 대해 실행해주기
			maxScore = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					score = 0;//
					if (map[r][c] == 0)
						start(r, c);
					maxScore = Math.max(maxScore, score);// 매번 최대갱신
				}
			}
			System.out.printf("#%d %d\n", t, maxScore);
		}
	}

	public static void start(int R, int C) {
		// 왼쪽으로
		left(R, C);

	}

	public static void left(int R, int C) {
		while (true) {
			// 일단 왼쪽으로
			C--;
			// 바뀐 인덱스가 벽을 만나면 포인트업 +break
			if (C < 0) {
				score++;
				right(R, C + 1);
				return; // 함수끝?
			}
			if (map[R][C] != 0)
				break;
		}
		// 0이 아니면 루프탈출
		int val = map[R][C];
		// 원점, 블랙홀을 만나면 리턴
		if (val == -1 || (R == sr && C == sc))
			return;
		// 웜홀을 만나면 다음 웜홀로 이동
		if (5 < val && val <= 10) {
			// 그래프 순회하면서 다음웜홀 찾기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == val && r != R && c != C) {
						start(r, c); // 다음 웜홀에서 다시 시작
						return;
					}
				}
			}
		} else {
			switch(val) {
			case 1 : 
				up(R,C);
				break;
			case 2 : 
				down(R,C);
			}
		}

	}

	private static void right() {
		// TODO Auto-generated method stub

	}

}
