import java.util.*;

public class 위상정렬_practice {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); // 3
        M = in.nextInt(); // 2

        indegree = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int st = in.nextInt();
            int ed = in.nextInt();
            graph[st].add(ed);
            indegree[ed]++;
        }

    }

    public static void TopologicalSort() {
        queue = new LinkedList<>();
        // 진입차수 배열 돌면서, indegree가 0이면 큐에 넣기
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        // queue에서 값 뺀 후 이어진 노드들 -- 하기. 해당 노드의 진입차수 0이면 출력
        while (!queue.isEmpty()) {
            int pa = queue.poll();
            // System.out.printf(pa + " ");
            for (int c : graph[pa]) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    queue.offer(c);
                }
            }
        }

    }
}
