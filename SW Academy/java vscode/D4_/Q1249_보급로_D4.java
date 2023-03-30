package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1249_보급로_D4 {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;// 어디로 가는지(끝정점) = 상하좌우 탐색!
			this.w = w;
		}

		public int compareTo(Node o) {// 우선순위큐의 정렬기준
			return Integer.compare(this.w, o.w);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			N = in.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				String[] line = in.next().split("");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(line[c]);
				}
			}
			adjList = new ArrayList[N * N];// arraylist가 담긴 배열.
			for (int i = 0; i < N * N; i++) {
				adjList[i] = new ArrayList<>();
			} // adjList 초기화!

			dist = new int[N * N];
			Arrays.fill(dist, INF);// 최소거리배열 초기화
			int[] dc = { -1, 0, 1, 0 };
			int[] dr = { 0, -1, 0, 1 };
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {// 4방탐색, 자리가 있으면 노드 만들어서 넣기
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						adjList[N * r + c].add(new Node(nr * N + nc, map[nr][nc]));
					}
				}
			}
			dijkstra(0);
			System.out.printf("#%d %d\n", t, dist[N*N-1]);
		}
	}

	private static void dijkstra(int start) {
		// 갱신한 값을 집어넣어야 하는것이 프림과의 차이.
		boolean[] visited = new boolean[N * N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		// 시작 정점을 뽑고
		// 우선순위큐에 시작 노드를 넣는다
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node n = pq.poll();// 큐에서 노드 꺼내기
			if (visited[n.v])
				continue;
			visited[n.v] = true;

			// 최단거리 테이블 값과 큐의 거리를 비교
			// 현재 꺼낸 노드의 거리가 최단거리 테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드
			// 탐색 하지 않고 큐에서 다음 노드 꺼내기
//			if(n.w > dist[n.idx]) continue;

			for (Node node : adjList[n.v]) {// 연결된 정점 비교
				// 만약 다음 노드를 거쳐서 이동할 때 값이 다음 노드의 최단거리 테이블 값보다 작으면
				if (dist[node.v] > n.w + node.w) {
					// 최단거리 값을 갱신
					dist[node.v] = n.w + node.w;
					// 갱신된 노드를 우선순위 큐에 넣어주기
					pq.offer(new Node(node.v, dist[node.v]));
				}
			}
		}
	}

}
