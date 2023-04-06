import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Q11779_2 {
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

	static int n, m, end, cntCity;
	static List<Edge>[] edges;
	static boolean[] visited;
	static int[] minDist, route;
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Edge> pq;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		edges = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		minDist = new int[n + 1];
		route = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < n + 1; i++) {
			minDist[i] = INF;
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
		
//		System.out.println(Arrays.toString(route)); //
		System.out.println(minDist[end]);
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		
		int curr = end;
		for(int i=0; i<n+1; i++) {
			stack.push(route[curr]);
			curr = route[curr];
			if(curr == start) break;
		}
		System.out.println(stack.size());//
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void Dijkstra(int start) {
		pq = new PriorityQueue<>();
		minDist[start] = 0;// 거리배열 첫순서는 0으로

		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (!visited[e.v]) {
				visited[e.v] = true;// 방문완!
				// cntCity++; // 방문한 도시

				if (e.v == end)
					break;
				for (Edge eg : edges[e.v]) {
					if (minDist[eg.v] > eg.val + e.val) {
						// 저장된 거리가 누적 거리 + 현재도시 거리보다 크면
						minDist[eg.v] = eg.val + e.val;
						route[eg.v] = e.v;
						pq.offer(new Edge(eg.v, minDist[eg.v]));
					}
				}
			}
		}
	}
}