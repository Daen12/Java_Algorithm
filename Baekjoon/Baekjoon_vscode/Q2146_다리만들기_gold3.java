import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2146_다리만들기_gold3 {
	// 가장 짧은 다리 = 육지의 끝
	// BFS / 그래프
	// 처음 1을 만나면 리턴
	// 이어진 그래프이면 하나의 육지이다.
	// 다른 육지인지도 확인해야!
	// 다리 = 바다를 만나고 그 다음 육지를 만나야한다.
	static int N, bridge;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = in.nextInt();
			}
		}
		visited = new boolean[N][N];
		int n = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c] && map[r][c] != 0) {// 바다가 아니고 아직 안간 육지이면
					paintGround(r, c, n++);
				}
			}
		}
//		for (int[] line : map) {
//			System.out.println(Arrays.toString(line));
//		}
//		visited = new boolean[N][N];
		bridge = Integer.MAX_VALUE;
		// 바다가 아니면 탐색 시작
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0) {
					visited = new boolean[N][N];
					findBridge(r, c, map[r][c]);
				}
			}
		}
		System.out.println(bridge);

	}

	public static void findBridge(int R, int C, int n) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { R, C, cnt});
		visited[R][C] = true;
		while (!queue.isEmpty()) {
			int[] idx = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = idx[0] + dr[d];
				int nc = idx[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				
				if(map[nr][nc] == 0) {//바다이거나 다른육지이면 
					queue.offer(new int[] {nr, nc, idx[2]+1});
					visited[nr][nc] = true;
				} else if (map[nr][nc] != n) {//바다도 아니고 같은육지도 아니면 = 다른육지 도착!
					bridge = Math.min(bridge, idx[2]);
				}
			}
		}
	}

	public static void paintGround(int R, int C, int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { R, C });
		map[R][C] = n;
		visited[R][C] = true;

		while (!queue.isEmpty()) {
			int[] idx = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = idx[0] + dr[d];
				int nc = idx[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				// 인접한 육지이고 아직 방문 안했으면 큐에 넣기.
				if (!visited[nr][nc] && map[nr][nc] != 0) {
					map[nr][nc] = n;
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
