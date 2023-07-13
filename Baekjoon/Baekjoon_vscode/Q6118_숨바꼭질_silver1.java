import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q6118_숨바꼭질_silver1 {
    // 다익스트라
    // 그래프 -> BFS
    static ArrayList<Integer>[] graph;
    static int N;
    static ArrayList<Integer> list;
    static int maxLevel;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();// 6 헛간 개수
        int M = in.nextInt();// 7 이어진 수
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        } // 그래프 초기화
        for (int i = 0; i < M; i++) {
            int st = in.nextInt();
            int ed = in.nextInt();
            graph[st].add(ed);
            graph[ed].add(st);
        }
        DFS();
        // Collections.sort(list, (Integer i1, Integer i2) -> {
        // return i1 - i2;
        // });
        System.out.println(maxLevel + ' ' + list.size());
    }

    public static void DFS() {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 });
        visited[1] = true;
        maxLevel = -1;
        list = new ArrayList<>();
        int cnt = 0;
        while (!queue.isEmpty()) {
            System.out.println("Poll");
            int[] pa = queue.poll();
            for (int child : graph[pa[0]]) {
                if (!visited[child]) {
                    queue.offer(new int[] { child, pa[1] + 1 });
                    visited[child] = true;
                    if (maxLevel < pa[1] + 1) {
                        cnt = 1;
                        maxLevel = pa[1] + 1;
                        list = new ArrayList<>();
                        list.add(child);
                    } else if (maxLevel == pa[1] + 1) {
                        cnt++;
                        list.add(child);
                    }
                }
            }
        }
    }
}
