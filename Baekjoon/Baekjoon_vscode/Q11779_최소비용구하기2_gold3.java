import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11779_최소비용구하기2_gold3 {
	public static class Edge implements Comparable<Edge> {
		int v, val;

		public Edge(int v, int val) {
			this.v = v;
			this.val = val;
		}

		public int compareTo(Edge o) {
			return Integer.compare(this.val, o.val);
		}
	}

	static int n, m, end;
	static List<Edge>[] edges;
	static boolean[] visited;
	static List<Integer>[] minDist;
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		edges = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		minDist = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
			minDist[i] = new ArrayList<>();
		}
		for (int i = 0; i < n + 1; i++) {
			minDist[i].add(INF);
		}
		for (int i = 0; i < m; i++) {
			int st = in.nextInt();
			int ed = in.nextInt();
			int val = in.nextInt();
			edges[st].add(new Edge(ed, val));
		}
		int start = in.nextInt();
		end = in.nextInt();
		Dijkstra(start);

		System.out.println(minDist[end].get(0));
		System.out.println(minDist[end].size() - 1);

		for (int i = 1; i < minDist[end].size(); i++) {
			System.out.print(minDist[end].get(i) + " ");
		}
		// System.out.println(Arrays.deepToString(minDist));

	}

	public static void Dijkstra(int start) {
		pq = new PriorityQueue<>();
		minDist[start].set(0, 0);// 거리배열 첫순서는 0으로
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			sb.append(e.v + " ");
			if (!visited[e.v]) {
				visited[e.v] = true;// 방문완!
				// cntCity++; // 방문한 도시

				if (e.v == end)
					break;
				for (Edge eg : edges[e.v]) {
					if (minDist[eg.v].get(0) > eg.val + e.val) {// 저장된 거리가 누적 거리 + 현재도시 거리보다 크면
						minDist[eg.v].set(0, eg.val + e.val);
						if (minDist[eg.v].size() == 1) {
							minDist[eg.v].add(e.v);
						} else {
							for (int i = 1; i < minDist[e.v].size(); i++) {
								minDist[eg.v].set(i, minDist[e.v].get(i));// 누적경로 쌓기
							}
						}
						minDist[eg.v].add(eg.v);// 본인 마지막에 누적
						pq.offer(new Edge(eg.v, minDist[eg.v].get(0)));
					}
				}
			}
		}

	}
}
