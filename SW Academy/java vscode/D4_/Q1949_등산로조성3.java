import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1949_등산로조성3 {

	static int N, K, length;
	static boolean[][] visited;
	static int[][] map, path;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();// 5
			K = in.nextInt();// 1
			map = new int[N][N];
			path = new int[N][N];
			visited = new boolean[N][N];
			length = 0;
			int top = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.nextInt();
					top = Math.max(map[r][c], top);
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == top) {//가장 높은 봉우리 찾으면 
						DFS(r,c,1, false);
					}
				}
			}
//			for (int[] line : path) {
//				System.out.println(Arrays.toString(line));
//			}
			System.out.printf("#%d %d\n", t, length);
		}
	}
	
	static void DFS(int R, int C, int cnt, boolean isCut) {
		length = Math.max(length, cnt);
		
		visited[R][C] = true;

		// r,c를 기준으로 4방향 탐색.
		for (int d = 0; d < 4; d++) {
			int nr = R + dr[d];
			int nc = C + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])// 범위 체크
				continue;
			//공사 안하고 갈수 있으면
			if (map[nr][nc] < map[R][C]) {
				DFS(nr, nc, cnt+1, isCut);
			}
			//공사 해야만 갈수 있는데 아직 안함
			else if(!isCut && map[nr][nc] - K < map[R][C]) {
				int temp = map[nr][nc];
				map[nr][nc] = map[R][C]-1;
				DFS(nr,nc,cnt+1, true);
				map[nr][nc] = temp;
			}
		}
		visited[R][C] = false;
	}
}
