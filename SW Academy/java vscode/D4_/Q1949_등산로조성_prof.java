import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1949_등산로조성_prof {
	// BFS
	// 클래스에 r,c,cnt저장
	// 큐에서 꺼낸 후 사방탐색, 만약 1이고 방문되지 않았으면 큐에 넣은 후 cnt++
	// public static class Kan {
	// int R, C, cnt;
	// int demolished;

	// public Kan(int r, int c, int cnt, int demolished) {
	// this.R = r;
	// this.C = c;
	// this.cnt = cnt;
	// this.demolished = demolished;
	// }
	// }

	static int N, K, length;
	static boolean[][] visited;
	static int[][] map, path;
	static Queue<Kan> queue;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();// 5
			K = in.nextInt();// 1
			map = new int[N][N];
			path = new int[N][N];
			int top = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.nextInt();
					top = Math.max(map[r][c], top);
				}
			}
			ArrayList<Integer> tops = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == top) {
						tops.add(r);// 가장 높은곳들 리스트에 저장
						tops.add(c);
					}
				}
			}
			length = 0;
			for (int i = 0; i < tops.size(); i += 2) {
				// for문 돌려서 k값 1~k까지 보기?
				visited = new boolean[N][N];
				DFS(tops.get(i), tops.get(i + 1), 1, false);
			}
			System.out.println(tops);
			for (int[] line : path) {
				System.out.println(Arrays.toString(line));
			}
			System.out.println(length);
		}
	}

	static void DFS(int R, int C, int cnt, boolean isCut) {
		// 만약 시작지점으로 돌아오면 방문처리 초기화??
		// 방문처리
		visited[R][C] = true;

		// System.out.print(v+1+" ");//그래프v가 0부터 시작.
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		// r,c를 기준으로 4방향 탐색.
		// 만약 다음좌표가 이동가능하면 DFS(nr, nc)

		for (int d = 0; d < 4; d++) {
			int nr = R + dr[d];
			int nc = C + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)// 범위 체크
				continue;

			// 사방탐색 후 -> 방문하지 않았을 때
			if (!visited[nr][nc]) {
				if (map[nr][nc] < map[R][C]) {// 새 인덱스가 전 인덱스보다 작으면
					DFS(nr, nc, cnt + 1, false);
				}
			}
			if (!visited[nr][nc] && map[nr][nc] - K < map[R][C]) {
				path[nr][nc] = 1;
				DFS(nr, nc, cnt + 1, false);
			}

		}
		// 사방탐색 했는데 조건에 안걸리면
		length = Math.max(length, cnt);
		System.out.println(cnt);
		for (int[] line : path) {
			System.out.println(Arrays.toString(line));
		}

		path = new int[N][N];
	}

	// public static void BFS(int R, int C) {
	// queue = new LinkedList<>();
	// visited = new boolean[2][N][M];// 깎음 && 안깎음
	// queue.offer(new Kan(0, 0, 1, 0));
	// visited[0][R][C] = true;
	// int[] dc = { 1, 0, -1, 0 };
	// int[] dr = { 0, 1, 0, -1 };

	// while (!queue.isEmpty()) {
	// Kan k = queue.poll();

	// // 시작지점 = 도착지점인 경우
	// if (N - 1 == 0 && M - 1 == 0) {
	// System.out.println(1);
	// System.exit(0);
	// }
	// for (int d = 0; d < 4; d++) {// 사방탐색
	// int nr = k.R + dr[d];
	// int nc = k.C + dc[d];
	// if (nr < 0 || nc < 0 || nr >= N || nc >= M)
	// continue;// 범위밖이면 아래 안봄

	// // 사방탐색 후 현 칸보다 숫자가 같거나 높으면
	// if (nr == N - 1 && nc == M - 1) {
	// ans = k.cnt + 1; // ans가 -1이다 = 목적지에 닫지 못함.
	// } // 리턴 안했으므로 가장 마지막에 도착하는 길이가 답에 저장됨.

	// // 다음칸에 벽이 있을 때 (1) 벽을 부순적이 있는지 체크 (2) 그 벽을 방문한 적이 있는지 체크
	// if (map[nr][nc] == 1) {// 부셨으면 1 아니면 0
	// // 부순적이 없고 방문한 적이 없으면 (부순버전 보기)
	// if (k.demolished == 0 && !visited[1][nr][nc]) {
	// visited[k.demolished][nr][nc] = true;
	// // 0버전 방문처리
	// // 1버전은 방문처리 안해줌.
	// queue.offer(new Kan(nr, nc, k.cnt + 1, 1));// 부신칸!
	// }
	// } else {// 벽이 아닐 경우, 벽을 '부순 여부'에 따라 방문했는지 체크
	// if (!visited[k.demolished][nr][nc]) {// 벽을 부쉈으면 1, 아니면 0버전을 봄
	// visited[k.demolished][nr][nc] = true;
	// queue.offer(new Kan(nr, nc, k.cnt + 1, k.demolished));
	// }
	// }
	// }
	// }
	// }
}
