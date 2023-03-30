package solving_club;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1251_하나로_D4 {
	static class Node {
		long x, y;

		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int st, ed;
		long dist;

		public Edge(int st, int ed, long dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
	static Edge[] edges;
	static Node[] nodes;
	static int comb;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();//노드의 수

			//N개의 섬에 대한 노드정보 저장
			long[] xArr = new long[N];
			long[] yArr = new long[N];
			for(int i=0; i<N; i++) {
				xArr[i] = in.nextLong();
			}
			for(int i=0; i<N; i++) {
				yArr[i] = in.nextLong();
			}
			nodes = new Node[N];
			for(int i=0; i<N; i++) {
				nodes[i] = new Node(xArr[i], yArr[i]);
			}
			double E = in.nextDouble();
			
			//인덱스 {1,2,3,4}의 조합 만들기 NC2
			edges = new Edge[N*(N-1)]; //간선의 개수 
		
			int d = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					edges[d++] = new Edge(i, j, Cal(nodes[i], nodes[j]));
					edges[d++] = new Edge(j, i, Cal(nodes[i], nodes[j]));

				}
			}
			Arrays.sort(edges);
//			for(Edge e : edges) {
//				System.out.println(e.dist + " ");
//			}
			int M = N*(N-1)/2;
			List<Edge>[] adjList = new ArrayList[N];
			
			for(int i=0; i<N; i++) {
				adjList[i] = new ArrayList<>();
			}
			for(Edge e : edges) {
				adjList[e.st].add(e);//간선을 st기준으로 adjList에 저장
			}
			
			//=================== PRIM AlGORITHM! ========================//
			boolean[] visited = new boolean[N]; //노드의 개수만큼 방문배열 만들기
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			//시작 정점을 뽑기
			visited[0] = true; //시작은 어디서 하든 상관없음
			pq.addAll(adjList[0]);
			int pick = 1;
			long ans = 0;
			while(pick<N) {//간선 N-1개 뽑을때까지
				Edge eg = pq.poll();
				if(visited[eg.ed]) continue;
				ans+=eg.dist;
				pq.addAll(adjList[eg.ed]);
				visited[eg.ed] = true;
				pick++;
			}
			System.out.printf("#%d %d\n", t, Math.round(ans*E));
		}
	}
	static long Cal(Node node1, Node node2) {
		return (long) (Math.pow(Math.abs(node1.x - node2.x), 2) + Math.pow(Math.abs(node1.y - node2.y), 2));
	}
}
