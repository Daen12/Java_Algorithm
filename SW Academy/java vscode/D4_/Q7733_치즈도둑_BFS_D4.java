import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7733_치즈도둑_BFS_D4 {
	// 100일동안 덩어리가 가장 많은 날을 출력
	// 1일 = 1을 0으로 전환
	// 2일 = 2를 0으로 전환
	// 누적된 상태
	static int[][] freezer;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static int maxCnt;
	static Queue<Node> queue;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			maxCnt = 0;// 덩어리가 한개일때가 최소이므로, maxCnt = 1로 시작하는게 논리적으로 맞음.
			int maxValue = 0;
			N = in.nextInt();
			freezer = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					freezer[r][c] = in.nextInt();
					maxValue = Math.max(maxValue, freezer[r][c]);
				}
			}
			for (int i = 1; i <= maxValue; i++) {// 몇일째?
				cnt = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (freezer[r][c] == i) {
							freezer[r][c] = 0;
						}
					}
				}
				// n일차 그래프 다 바꿔준다음에
				visited = new boolean[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!visited[r][c] && freezer[r][c] != 0) {
							BFS(r, c);// 치즈 한덩어리만큼 돌고 나옴.
						}
					}
				}
				maxCnt = Math.max(cnt, maxCnt);
			}
			System.out.printf("#%d %d\n", t, maxCnt);
		}
	}

	static void BFS(int R, int C) {
		queue = new LinkedList<>();
		// 시작 정점을 큐에 삽입한다.
		queue.offer(new Node(R, C));
		visited[R][C] = true;

		// 큐가 공백이 아니라면 반복문 수행
		while (!queue.isEmpty()) {
			Node root = queue.poll();
			for (int d = 0; d < 4; d++) {// 4방탐색
				int nr = root.r + dr[d];
				int nc = root.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)// 범위 체크
					continue;

				if (!visited[nr][nc] && freezer[nr][nc] != 0) {
					// 방문하지 않았으면서 길이 있으면
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
				}
			}
		}
		cnt++;
	}

}
