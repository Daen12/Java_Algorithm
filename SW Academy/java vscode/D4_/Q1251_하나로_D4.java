package solving_club;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1251_하나로_D4 {
	static class Node {
		long x, y;

		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge {
		int st, ed;
		long dist;

		public Edge(int st, int ed, long dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}
	}
	static Edge[] edges;
	static Node[] nodes;
	static int[] parents;
	static int comb;
	static boolean[] visited;
	static boolean ready;
	static int e;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();//노드의 수
			parents = new int[N];
			//make-set
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
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
			comb = 0;
			e = 0;
			ready = false;
			visited = new boolean[N];
			Combination(0,0,N);
			edges = new Edge[comb]; //간선이 comb개!
			comb = 0;
			ready = true;
			e = 0;
			visited = new boolean[N];
			Combination(0,0,N);
			//edges를 정렬하기!
			Arrays.sort(edges, new Comparator<Edge>() {
				public int compare(Edge o1, Edge o2) {
					int result = o1.dist - o2.dist <0? -1 : 1;
					return result;
				}
			});

			long minCost = 0;
			int pick = 0;
			for(int i=0; i<comb; i++) {
				int x = edges[i].st;
				int y = edges[i].ed;
				if(findSet(x)!=findSet(y)) {
					union(x,y);
					minCost+=edges[i].dist;
					pick++;
				}
				if(pick == N-1) break;
			}
			System.out.printf("#%d %d\n", t, Math.round(minCost*E));
		}
	}
	static void Combination(int depth, int idx, int N) {
		if(depth == 2) {
			if(ready) {
				int[] sel = new int[2];
				int j = 0;
				for(int i=0; i<N; i++) {
					if(visited[i]) {
						sel[j++] = i;
					}
				}
				//i번째 노드들의 정보가 저장된 간선 만들기
				edges[e++] = new Edge(sel[0], sel[1], Cal(nodes[sel[0]], nodes[sel[1]]));
			}
			comb++;
			return;
		}
		
		for(int i=idx; i<N; i++) {
			visited[i] = true;
			Combination(depth+1, i+1, N);
			visited[i] = false;
		}
		
	}
	static long Cal(Node node1, Node node2) {
		return (long) (Math.pow(Math.abs(node1.x - node2.x), 2) + Math.pow(Math.abs(node1.y - node2.y), 2));
		
	}
	static int findSet(int x) {//Path compression!
		if(parents[x] != x) {
			parents[x] = findSet(parents[x]);
		}
		return parents[x];
	}
	static void union(int x, int y) {
		parents[findSet(y)] = findSet(x);//랭크 따로 고려하지 않음.
		//y를 무조건 x 밑으로!
		
	}
}
