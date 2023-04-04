import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.border.SoftBevelBorder;

public class Q2252_줄세우기_gold3 {
    // n은 노드의 수, M은 비교(진출 - 진입)
    // 그래프는 n+1인덱스
    // inD는 진입차수를 나타낸 배열
    static int N;
    static int[] inD;
    static List<Integer>[] graph;
    static Queue<Integer> queue;
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
        queue = new LinkedList<>();
        TopSort();
        System.out.println(sb);

    }

    public static void TopSort() {
        for (int i = 1; i < N + 1; i++) {
            if (inD[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 큐에서 값을 빼기
            int node = queue.poll();
            sb.append(node + " ");
            for (int n : graph[node]) {// 인접 노드들에 대해서
                inD[n]--;
                if (inD[n] == 0) {
                    queue.offer(n);
                }
            }
        }
    }
}
