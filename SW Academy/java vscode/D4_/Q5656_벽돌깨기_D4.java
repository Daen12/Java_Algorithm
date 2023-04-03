package solving_club;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q5656_벽돌깨기_D4 {
	// 벽돌깨면 적혀있는 수만큼 터진 후에 빈공간만큼 내려온다.
	// 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.
	// 1.제거하는 함수
	// 2.만약 제거하는 범위에 숫자가 1 이상이라면, 재귀로 다시 제거
	// 3.제거가 끝난 후 밑에 0이 있으면 그만큼 shift해주는 함수
	static int[][] map, tempMap;
	static int W, H, N, prev, cnt, maxCnt;
	static int[] dc = { -1, 0, 1, 0 };
	static int[] dr = { 0, -1, 0, 1 };
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();
			W = in.nextInt();// c
			H = in.nextInt();// r
			prev = 0;
			map = new int[H][W];
			tempMap = new int[H][W];
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					tempMap[r][c] = in.nextInt();
					if (tempMap[r][c] != 0)
						prev++;// 처음 구슬 개수 저장
				}
			}
			//중복순열로 N개 찾기
			visited = new boolean[W];
			maxCnt = -1;
			
			Combination(0);
			System.out.printf("#%d %d\n", t, prev - maxCnt);
		}
	}

	public static void Combination(int depth) {// combination/permutation
		if (depth == N) {
			cnt = 0;
			for(int r=0; r<H; r++) {//map원상복구
				map[r] = tempMap[r].clone();
			}
			
			for(int c : stack) {
				init(c);
			}
			// 모두 cnt완료
			// maxCnt보다 구슬 많이 깼으면 갱신
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		for (int i = 0; i < W; i++) {
			stack.push(i);
			Combination(depth + 1);
			stack.pop();
		}
	}

	public static void init(int C) {// 어떤 칼럼에 쏠지
		if (isR(C)) {// 해당칼럼에 구슬이 있으면
			int R = findR(C);// 구슬 행 번호찾고
			shoot(R, C);// 여기서 shoot 재귀 실행
			organize();// shoot이후 비어있는 공간 구슬로 채워주기
		}
	}

	private static void organize() {
		for (int c = 0; c < W; c++) {
			int p = 0;
			for (int r = 0; r < H; r++) {// 위에서부터 하나씩 shift
				if (map[r][c] == 0) {
					int q = r;
					for (int i = q; p < i; i--) {
						map[i][c] = map[i - 1][c];
					}
					map[p][c] = 0;
					p++;
				}
			}
		}
	}

	public static void shoot(int R, int C) {
		int num = map[R][C];// 구슬 숫자
		map[R][C] = 0; // 0만들고
		cnt++;// 쏜 구슬 개수 저장
		int spread = 1;
		while (spread < num) {
			// 해당 자리의 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = R + spread * dr[d];
				int nc = C + spread * dc[d];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == 0)
					continue;

				shoot(nr, nc);
			}
			// 4방탐색 후 spread++
			spread++;
		}
	}

	public static int findR(int C) {
		// c의 행 인덱스 = 가장 먼저 0이 아닌수
		for (int r = 0; r < H; r++) {
			if (map[r][C] != 0) {
				return r;
			}
		}
		return -1;// 구슬없음
	}

	public static boolean isR(int C) {// 이함수 불필요?
		// c의 행 인덱스 = 가장 먼저 0이 아닌수
		for (int r = 0; r < H; r++) {
			if (map[r][C] != 0) {
				return true;
			}
		}
		return false;
	}
}
