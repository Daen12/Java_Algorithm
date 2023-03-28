package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q7733_치즈도둑_D4 {
	// 100일동안 덩어리가 가장 많은 날을 출력
	// 1일 = 1을 0으로 전환
	// 2일 = 2를 0으로 전환
	// 누적된 상태
	static int[][] freezer;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static int maxCnt;
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			maxCnt = 0;
			N = in.nextInt();
			freezer = new int[N][N];
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					freezer[r][c] = in.nextInt();
				}
			}
			for (int i = 1; i <= 100; i++) {// 몇일째?
				cnt = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (freezer[r][c] == i) {
							freezer[r][c] = 0;
						}
					}
				}
				// 그래프 다 바꿔준다음에
				for(int[]line : freezer) {
					System.out.println(Arrays.toString(line));
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						cnt+=DFS(r,c);//치즈 한덩어리만큼 돌고 나옴.
					}
				}
				System.out.println(cnt);
				maxCnt = Math.max(cnt, maxCnt);
			}
			System.out.printf("#%d %d\n", t, maxCnt);
		}
	}

	static int DFS(int R, int C) {
		if(visited[R][C] == true || freezer[R][C] == 0) return 0;//만약 방문한 치즈라면 바로리턴.
		// 방문처리
//		visited = new boolean[N][N];
		visited[R][C] = true;
		int[] dr = { -1, 0, 1, 0};
		int[] dc = { 0, 1, 0 ,-1};
		// 연결되어있으면서 아직 방문하지 않은 정점을 재귀호출
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = R + dr[d];
					int nc = C + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)// 범위 체크
						continue;
					if (!visited[nr][nc] && freezer[nr][nc] != 0) {
						// 방문하지 않았으면서 길이 있으면
						DFS(nr, nc);
					}
				}
			}
		}
		return 1;
	}
}
