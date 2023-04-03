import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	//BFS처럼 꺼낼때 방문처리 하면 자식노드가 중복으로 큐에 들어가게 되므로
	//(큐에서 나오기 전에 같은 것들이 여러개 들어갈 수 있으므로)
	//큐에 넣은 직후 방문처리 해주어야 함!
	
	//Deque = 모든 방향에서 삽입, 출력 가능한 큐!
	static boolean[]visited;
	static int[][]graph;
	static int N;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		N = 7;
		graph = new int[][] { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 }, };
		visited = new boolean[N];
		queue = new LinkedList<>();
		BFS(0);
	}
	static void BFS(int v) {
		//시작 정점을 큐에 삽입한다.
		queue.add(v);
		visited[v] = true;
		
		//큐가 공백이 아니라면 반복문 수행
		while(!queue.isEmpty()) {
			int root = queue.poll();
			System.out.print(root+" ");
			//해당 노드의 자식들을 큐에 삽입 후 방문처리
			for(int i=0; i<N; i++) {
				if(!visited[i] && graph[root][i]==1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
