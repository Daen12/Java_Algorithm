import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2206_벽부수고이동하기3_gold3 {
	// BFS
	// 클래스에 r,c,cnt저장
	// 큐에서 꺼낸 후 사방탐색, 만약 1이고 방문되지 않았으면 큐에 넣은 후 cnt++
	public static class Kan {
		int R, C, cnt;
		int demolished;

		public Kan(int r, int c, int cnt, int demolished) {
			this.R = r;
			this.C = c;
			this.cnt = cnt;
			this.demolished = demolished;
		}
	}

	static int N, M, ans;
	static boolean[][][] visited;
	static int[][] map;
	static Queue<Kan> queue;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();// 4
		M = in.nextInt();// 6
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String[] line = in.next().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(line[c]);
			}
		}
		// 시작지점 = 도착지점인 경우 (bfs에서는 사방탐색 하느라 못잡음!)
		if (N - 1 == 0 && M - 1 == 0) {
			System.out.println(1);
			System.exit(0);
		}

		// 벽 부수기
		ans = -1;
		BFS();
		// for(int[] line : map) {
		// System.out.println(Arrays.toString(line));
		// }
		System.out.println(ans);
	}

	public static void BFS() {
		queue = new LinkedList<>();
		visited = new boolean[2][N][M];
		queue.offer(new Kan(0, 0, 1, 0));
		visited[0][0][0] = true;
		int[] dc = { 1, 0, -1, 0 };
		int[] dr = { 0, 1, 0, -1 };

		while (!queue.isEmpty()) {
			Kan k = queue.poll();
			for (int d = 0; d < 4; d++) {// 사방탐색
				int nr = k.R + dr[d];
				int nc = k.C + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;// 범위밖이면 아래 안봄

				// 도착지점에 도달 시
				if (nr == N - 1 && nc == M - 1) {
					ans = k.cnt + 1; // ans가 -1이다 = 목적지에 닫지 못함.
					return;// 먼저 도착했으면 종료
				}

				// 다음칸에 벽이 있을 때 (1) 벽을 부순적이 있는지 체크 (2) 그 벽을 방문한 적이 있는지 체크
				if (map[nr][nc] == 1) {// 부셨으면 1 아니면 0
					// 부순적이 없고 방문한 적이 없으면 (부순버전 보기)
					if (k.demolished == 0 && !visited[1][nr][nc]) {
						visited[k.demolished][nr][nc] = true;
						// 0버전 방문처리
						// 1버전은 방문처리 안해줌.
						queue.offer(new Kan(nr, nc, k.cnt + 1, 1));// 부신칸!
					}
				} else {// 벽이 아닐 경우, 벽을 '부순 여부'에 따라 방문했는지 체크
					if (!visited[k.demolished][nr][nc]) {// 벽을 부쉈으면 1, 아니면 0버전을 봄
						visited[k.demolished][nr][nc] = true;
						queue.offer(new Kan(nr, nc, k.cnt + 1, k.demolished));
					}
				}
			}
		}
	}
}
