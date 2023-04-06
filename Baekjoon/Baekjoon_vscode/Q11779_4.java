
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11779_4 {
	public static class Edge implements Comparable<Edge> {
		int v;
		long val;

		public Edge(int v, long val) {
			this.v = v;
			this.val = val;
		}

		public int compareTo(Edge o) {
			return Long.compare(this.val, o.val);
		}
	}

	static int n, m, end, cntCity;
	static List<Edge>[] edges;
	static boolean[] visited;
	static List<Long>[] minDist;
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Edge> pq;
	static StringBuilder sb;

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
			minDist[i].add((long) INF);//첫 값은 무한대로 채우기
		}
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n; j++) {
				minDist[i].add((long) -1);//두번째값부터 n개만큼 -1로 초기화 (자리 깔기)
			}
		}
		for (int i = 0; i < m; i++) {
			int st = in.nextInt();
			int ed = in.nextInt();
			long val = in.nextInt();
			edges[st].add(new Edge(ed, val));
		}
		int start = in.nextInt();
		end = in.nextInt();
		sb= new StringBuilder();
		Dijkstra(start);

		System.out.println(minDist[end].get(0));
		int cnt = 0;
		for (int i = 1; i < minDist[end].size(); i++) {
			if(minDist[end].get(i) == -1) break;
			sb.append(minDist[end].get(i) + " ");
//			System.out.print(minDist[end].get(i) + " ");
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(sb);
		 System.out.println(Arrays.deepToString(minDist));

	}

	public static void Dijkstra(int start) {
		pq = new PriorityQueue<>();
		minDist[start].set(0, (long) 0);// 거리배열 첫순서는 0으로
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (!visited[e.v]) {
				visited[e.v] = true;// 방문완!

				if (e.v == end)
					break;
				for (Edge eg : edges[e.v]) {
					if (minDist[eg.v].get(0) > eg.val + e.val) {// 저장된 거리가 누적 거리 + 현재도시 거리보다 크면
						minDist[eg.v].set(0, (long) (eg.val + e.val));
						
						if (minDist[eg.v].get(1) == -1) {//첫번째 값이 -1이면 = 시작값 아직 안넣음.
							minDist[eg.v].set(1, (long) e.v);
						} else {
							for (int i = 1; i < minDist[e.v].size(); i++) {
								minDist[eg.v].set(i, minDist[e.v].get(i));// 누적경로 쌓기
							}
						}
						for(int i=0; i<n+1; i++) {//전체 리스트 돌면서
							if(minDist[eg.v].get(i) == -1){
								minDist[eg.v].set(i, (long) eg.v);// 본인 마지막에 누적
								break;
							}
						}
						pq.offer(new Edge(eg.v, minDist[eg.v].get(0)));
					}
				}
			}
		}

	}
}