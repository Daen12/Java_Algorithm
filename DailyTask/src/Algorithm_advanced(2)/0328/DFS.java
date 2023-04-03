import java.util.Stack;

public class DFS {
	static boolean[] visited;
	static int[][] graph;
	static Stack<Integer> stack = new Stack<>();
	static int N;

	public static void main(String[] args) {
		N = 7;
		graph = new int[][] { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 }, };
		visited = new boolean[N];
		DFS(0);
		
	}
	
	static void DFS(int v) {
		//방문처리
		visited[v] = true;
		System.out.print(v+1+" ");//그래프v가 0부터 시작.
		//연결되어있으면서 아직 방문하지 않은 정점을 재귀호출
		for(int i=0; i<N; i++) {
			//방문하지 않았으면서 인접노드이면 
			if(!visited[i]&&graph[v][i]==1) {
				DFS(i);
			}
		}
	}

}
