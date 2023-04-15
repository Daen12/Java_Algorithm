import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1949_등산로조성_me {

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
			visited = new boolean[N][N];
			int top = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.nextInt();
					top = Math.max(map[r][c], top);
				}
			}
			length = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == top) {
						DFS(r,c,1,false);
					}
				}
			}
			System.out.printf("#%d %d\n", t, length);
		}
	}

	static void DFS(int R, int C, int cnt, boolean isCut) {
		length = Math.max(length, cnt);
		
		// r,c를 기준으로 4방향 탐색.
		visited[R][C] = true;//방문체크
		
		for (int d = 0; d < 4; d++) {
			int nr = R + dr[d];
			int nc = C + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])// 범위 체크
				continue;

			if(!isCut) { //잘리지 않았으면 
				if (map[nr][nc] < map[R][C]) {//새 인덱스가 현재보다 작으면
					DFS(nr, nc, cnt+1, false);
				} else if(map[nr][nc] - K < map[R][C]) {//잘랐을때 접근 가능하면
					int temp = map[nr][nc];
					map[nr][nc] = map[R][C]-1;
					DFS(nr, nc, cnt+1, true);//자름
					map[nr][nc] = temp;
				}
			} else { //잘렸으면 
				if (map[nr][nc] < map[R][C]) {
					DFS(nr, nc, cnt+1, true);//자름
				} 
			}
		}
		visited[R][C] = false;
	}
}
