import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q1766_문제집_gold2_pq {
    // n은 노드의 수, M은 비교(진출 - 진입)
    // 그래프는 n+1인덱스
    // inD는 진입차수를 나타낸 배열
    static int N;
    static int[] inD;
    static boolean[] visited;
    static List<Integer>[] graph;
    // static Queue<Integer> queue;
    static PriorityQueue<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int M = in.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        inD = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int st = in.nextInt();
            int ed = in.nextInt();
            graph[st].add(ed);
            inD[ed]++;
        }
        sb = new StringBuilder();
        // queue = new LinkedList<>();
        queue = new PriorityQueue<>();
        visited = new boolean[N + 1];
        TopSort();
        System.out.println(sb);

    }

    public static void TopSort() {
        for (int i = 1; i < N + 1; i++) {
            if (inD[i] == 0) {
                queue.offer(i);
                // visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            // 큐에서 값을 빼기
            int node = queue.poll();
            sb.append(node + " ");
            for (int n : graph[node]) {// 인접 노드들에 대해서
                inD[n]--;// 먼저 진입차수 배열 다 바꿔주고
                if (inD[n] == 0 && !visited[n]) {
                    queue.offer(n);
                }
            }
            // for (int i = 1; i < N + 1; i++) {// 앞에서부터 다시 진입차수 배열 스캔하며 큐에 넣어주기
            // if (inD[i] == 0 && !visited[i]) {
            // queue.offer(i);
            // visited[i] = true;
            // }
            // }
        }
    }
}
