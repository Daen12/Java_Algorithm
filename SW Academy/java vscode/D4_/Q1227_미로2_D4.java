package solving_club;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q1227_미로2_D4 {
	static boolean[][] visited;
	static int[][] graph;
	static Queue<Node> queue = new LinkedList<>();
	static int N, result, goalR, goalC;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Node {// 노드 클래스를 만든다
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = 100;
		for (int t = 1; t <= 1; t++) {
			queue = new LinkedList<>();
			int tc = in.nextInt();
			graph = new int[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				String[] line = in.next().split("");
				for (int c = 0; c < N; c++) {
					graph[r][c] = Integer.parseInt(line[c]);
					if (graph[r][c] == 3) {
						goalR = r;
						goalC = c;
					}
				}
			}
			result = 0;
			BFS(1, 1);// 출발인덱스
			System.out.printf("#%d %d\n", t, result);
			for (int[] line : graph) {
				System.out.println(Arrays.toString(line));
			}
		}
	}

	static void BFS(int R, int C) {

		// 시작 정점을 큐에 삽입한다.
		queue.offer(new Node(R, C));
		visited[R][C] = true;

		// 큐가 공백이 아니라면 반복문 수행
		while (!queue.isEmpty()) {
			Node root = queue.poll();
			for (int d = 0; d < 4; d++) {//4방탐색
				int nr = root.r + dr[d];
				int nc = root.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)// 범위 체크
					continue;
				if (graph[nr][nc] == 3)
					result = 1;// 3을 만나면 result바꿔주기
				if (!visited[nr][nc] && graph[nr][nc] == 0) {
					// 방문하지 않았으면서 길이 있으면
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
					graph[nr][nc] = 9;
				}
			}
		}
	}
}
