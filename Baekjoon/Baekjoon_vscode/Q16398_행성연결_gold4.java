import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q16398_행성연결_gold4 {
    // Use Prim!
    // 진출노드, 가중치 정보 담은 간선 클래스 만들기
    // 인덱스 = 진출노드인 인접간선 리스트 만들기
    // 우선순위큐에 노드 하나 담고 방문처리 -> 담은 노드의 진출간선 모두 담은 후 해당 노드 방문처리
    // 뽑은 수가 노드-1이면 종료

    public static class Edge implements Comparable<Edge> {
        int ed;
        int w;

        public Edge(int ed, int w) {
            this.ed = ed;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static boolean[] visited;
    static List<Edge>[] adj;
    static PriorityQueue<Edge> pq;
    static long minCost;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        adj = new ArrayList[N];// # of nodes
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        // 입력
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r == c) {
                    int g = in.nextInt();
                    continue;
                }
                adj[r].add(new Edge(c, in.nextInt()));// 행렬이므로 양방입력
            }
        }
        pq = new PriorityQueue<>();
        int start = 0;
        minCost = 0;
        Prim(start);

        System.out.println(minCost);
    }

    public static void Prim(int start) {
        pq.addAll(adj[start]); // 시작노드의 인접간선 모두 삽입
        visited[start] = true;
        int pick = 1;
        while (pick < N) {
            Edge eg = pq.poll();// 인접간선중 최소비용인 애가 뽑히겠지
            if (!visited[eg.ed]) {// 간선 따라 만나는 노드를 아직 방문 안했으면
                minCost += eg.w;
                pq.addAll(adj[eg.ed]); // 그 노드의 인접 간선 큐에 다 저장
                visited[eg.ed] = true;// 방문처리
                pick++;
            }
        }

    }

}
