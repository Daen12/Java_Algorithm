import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstraa_for {
	// A-B의 최솟값과 B-C의 최솟값이 곧 A-C의 최솟값이다.
	// 시작정점이 중요. 시작에서 어디까지 가는데 최단경로인가?
	// 거리배열을 무한대로 초기화
	// 아직 방문하지 않은 값들의 거리와 현재 정점에서의 가중치의 '합' 비교, 최소 저장
	// 만약 D까지만 가는경로가 궁금하다면?
	// D가 뽑히는 순간 멈추면 됨! (뽑혔다 = 시작정점에서 D까지 가는 최솟값은 이미 구했어!)
	// 모든 정점이 다 연결 안되어있을 수도 있음. = 연결 안되어있음 값이 무한대로 남아있는 경우 존재 가능
	// 그러나 음수가 존재할 시, 돌아가는게 더 나을수도 있는데
	// 다익스트라는 근시안적인 관점때문에 이 경우를 못찾는다.
	// 이럴땐 벨만-포드를 사용해야
	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";


	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;//어디로 가는지(끝정점)
			this.w = w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) {
		Scanner in = new Scanner(input);
		V = in.nextInt();
		E = in.nextInt();
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);

		// 입력받기
		for (int i = 0; i < E; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int W = in.nextInt();
			// 유향그래프!
			adjList[A].add(new Node(B, W)); // 인접리스트 노드 추가
		}

		dijkstra(0);// 0번 정점을 넣겠다
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		dist[start] = 0;// 시작노드에서 시작노드까지의 거리는 0
		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;

			// 선택하지 않은 정점 중 dist가 가장 짧은것 고르기
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx == -1)
				break; // 선택가능한 친구 없으면 break.

			visited[idx] = true;
			// 갱신할 수 잇으면 갱신
			for (int j = 0; j < adjList[idx].size(); j++) {//idx번 정점과 연결된 노드들 
				Node curr = adjList[idx].get(j);
				// 방문하지 않았고 연결도 되었고(인접행렬일때만)
				// 이미 가지고 있는 값보다 최솟값이 있으면 갱신
				if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}
		}

	}

}