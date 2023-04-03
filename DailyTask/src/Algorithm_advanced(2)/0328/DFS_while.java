import java.util.Stack;

public class DFS_while {
	static boolean[] visited = new boolean[7];
	static int[][] graph;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		graph = new int[][] { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 }, };
		// 시작노드
		stack.push(0);
		visited[0] = true;
		while (!stack.isEmpty()) {
			int nodeIdx = stack.pop();
			// 방문 노드 출력
			System.out.println(nodeIdx + " ");
			// 방문노드의 인접노드 찾기
			for (int links : graph[nodeIdx]) {
				if (!visited[links]) {
					stack.push(links);
					visited[links] = true;
				}
			}
		}

	}

}
