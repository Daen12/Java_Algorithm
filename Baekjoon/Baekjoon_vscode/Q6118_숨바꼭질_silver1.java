import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q6118_숨바꼭질_silver1 {
    // 다익스트라
    // 그래프 -> BFS
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();// 6 헛간 개수
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
    }

    public static void DFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 });
        int maxLevel = -1;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {

        }
    }
}
