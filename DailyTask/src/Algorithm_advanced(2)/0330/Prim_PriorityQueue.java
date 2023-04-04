import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_PriorityQueue {
	//왜 아무 정점이나 선택해도 될까?
	//신장트리의 특징 : 모든 정점을 최소한의 간선을 이용해서 연결할 것이므로
	//아무 정점에서나 시작해도 된다.
	
	//1. 우선순위큐에 (정점, 가중치) 순으로 저장
	//2. 우선순위큐에서 하나 꺼내기 (꺼낸 정점이 이미 mst에 포함됐다면 다시 돌아감)
	//3. 꺼낸 v와 연결된 간선을 모두 살핀다.
	//4. 방문하지 않은 간선에 대해 우선순위큐에 추가한다.
	
	//5번 방문처리 - DIST 0
	//5번과 연결된 모든 노드의 거리 최솟값 거리배열에 저장
	//어디서 왔는지 (5) 저장
	//이중 최솟값 뽑기 (뽑혔다 = 최선의 선택이다)
	//3번 방문처리
	//연결된 모든 노드의 거리 최솟값 거리배열에 저장.
	//어디서왔는지(3) 저장
	//이 중 최솟값 뽑기 = 4번 방문처리
	//연결된 모든 노드의 거리에 대해 최솟값 갱신 
	//어디서 왔는지 (4)
	//최솟값은 이제 2번 = 방문처리
	//최솟값 갱신 후 뽑기6
	//남은 노드 0번 어디서 왔는지 확인 후 (2) 0-2 마지막으로 선택!
	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51";
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge implements Comparable<Edge>{
		int st, ed, w;
		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		//클래스 안에서 comparable 정의
		public int compareTo(Edge o) {//아래 두 방법! 헷갈린다면 아래꺼 사용
//			return this.w - o.w;
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(input);
		int V = in.nextInt();
		int E = in.nextInt();
		
		//인접리스트
		List<Edge>[] adjList = new ArrayList[V];
		//바구니 초기화
		for(int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			int A = in.nextInt();//시작정점
			int B = in.nextInt();//도착정점
			int W = in.nextInt();//가중치
			//무향그래프!
			adjList[A].add(new Edge(A,B,W));
			adjList[B].add(new Edge(B,A,W));
		}
		//방문처리를 위한 배열
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//시작정점을 뽑고 
		visited[0] = true;
		//인접 간선들을 넣는다
		pq.addAll(adjList[0]);
		int pick = 1;
		int ans = 0;
		//pick<V일때만 돌기!
		while(pick<V) {
			Edge e = pq.poll();//큐 안에 들어있는 최고의값
			if(visited[e.ed]) continue; //이미 뽑은 정점이라면 패스
			ans+=e.w;
			pq.addAll(adjList[e.ed]);//뽑은 값과 연결된 값들
			visited[e.ed] = true;//방문처리
			pick++;
		}
		System.out.println(ans);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
