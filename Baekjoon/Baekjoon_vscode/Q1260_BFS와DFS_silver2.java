import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q1260_BFS와DFS_silver2 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();// 노드의 개수
        M = in.nextInt();// 간선의 개수
        int root = in.nextInt();// 탐색시작

        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int st = in.nextInt();
            int ed = in.nextInt();
            graph[st].add(ed); // {{}, {2,3,4}, {4}, {4}}
            graph[ed].add(st);
        }
        for (int i = 1; i < N+1; i++) {// 입력된 배열 정렬하기
            Collections.sort(graph[i]);
        }
        visited = new boolean[N + 1];
        DFS(root);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(root);

    }

    public static void DFS(int root) {// 몇번부터 탐색?
        visited[root] = true;
        System.out.print(root + " ");

        for (int i = 0; i < graph[root].size(); i++) {
            if (!visited[graph[root].get(i)]) {
                DFS(graph[root].get(i));
            }
        }
    }

    public static void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.printf(node + " ");
            for (int i = 0; i < graph[node].size(); i++) {
                if (!visited[graph[node].get(i)]) {
                    queue.offer(graph[node].get(i));
                    visited[graph[node].get(i)] = true;
                }
            }
        }
    }
}
