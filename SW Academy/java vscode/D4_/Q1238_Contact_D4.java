package solving_club;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1238_Contact_D4 {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;//어디로 가는지(끝정점)
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {// 우선순위큐의 정렬기준
			return Integer.compare(this.w, o.w);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			adjList = new ArrayList[100+1];//최대 100명
			for(int i=0; i<101; i++) {
				adjList[i] = new ArrayList<>();
			}
			int input = in.nextInt();//24
			int start = in.nextInt();//2
			
			for(int i=0; i<input/2; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adjList[from].add(new Node(to, 1));
			}
			dist = new int[101];//사람의 수만큼 입력
			Arrays.fill(dist, INF);

			Dijkstra(start);
			int max_value = -1;
			for(int i=0; i<101; i++) {
				if(dist[i] == Integer.MAX_VALUE) continue;
				max_value = Math.max(max_value, dist[i]);
			}
			int answer = 0;
			for(int i=100; 0<=i; i--) {
				if(dist[i] == max_value) {
					answer = i;
					break;
				}
			}
			
//			System.out.println(Arrays.toString(dist));
			System.out.printf("#%d %d\n", t, answer);
			
		}
	}
	
	public static void Dijkstra(int start) {
		boolean[] visited = new boolean[101];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		//시작정점을 뽑고
		//우선순위큐에 시작 노드를 넣기
		pq.offer(new Node(start,0)); //두번째 weight은 자기 자신과의 거리(속도)

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(visited[n.v]) continue;//방문한 노드라면 패스
			visited[n.v] = true;
			for(Node node : adjList[n.v]) {
				if(dist[node.v]> n.w + node.w) {
					dist[node.v] = n.w + node.w;
					pq.offer(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
