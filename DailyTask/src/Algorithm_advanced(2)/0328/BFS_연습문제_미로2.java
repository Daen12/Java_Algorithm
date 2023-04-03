import java.util.LinkedList;
import java.util.Queue;

public class BFS_연습문제_미로2 {
	//BFS처럼 꺼낼때 방문처리 하면 자식노드가 중복으로 큐에 들어가게 되므로
	//(큐에서 나오기 전에 같은 것들이 여러개 들어갈 수 있으므로)
	//큐에 넣은 직후 방문처리 해주어야 함!
	
	//Deque = 모든 방향에서 삽입, 출력 가능한 큐!
	
	//1.distance[][] 만들면 visited 안만들어도 됨.
	//2. queue에 list를 넣어서 0번r 1번c, 2번dist 이런식으로
	//아니면 queue.add (new pos(nr,nc,root.dist+1))
	//3. 길이를 저장하는 변수를 생성. (queue size로 묶어서 같은 레벨끼리 처리)
	//queue.size()
	
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
			System.out.println(queue);
			int size = queue.size();//1
			for(int i=0; i<size; i++) {
				int root = queue.poll();
				for(int j=0; j<N; j++) {
					if(!visited[j] && graph[root][j]==1) {
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
		}
	}
	
}
