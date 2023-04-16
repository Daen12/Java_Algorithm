import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class Q1774_우주신과의교감_gold3 {
    static int N, M;
    static Edge[] edges;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int st, ed;

        public Edge(int st, int ed, double dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }

        double dist;

        public int compareTo(Edge o) {
            return this.dist - o.dist < 0 ? -1 : 1;
            // return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();// 좌표(노드)의 개수
        M = in.nextInt();// 이미 연결된 좌표 (N-1-M개만 pick하면 됨)
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            union(in.nextInt(), in.nextInt());
        }
        edges = new Edge[N * (N - 1) / 2];
        int k = 0;
        for (int i = 0; i < N - 1; i++) { // arr에 담겨있는 애들
            for (int j = i + 1; j < N; j++) {
                // i번째 노드와 j번째 노드를 연결한 간선을 담자!
                edges[k++] = new Edge(i + 1, j + 1, cal(arr[i][0], arr[i][1], arr[j][0], arr[j][1]));
            }
        }
        // edges의 간선개수는 k-1개
        // Arrays.sort(edges, new Comparator<Edge>() {
        // public int compare(Edge o1, Edge o2) {
        // return o1.dist - o2.dist < 0 ? -1 : 1;
        // }
        // });
        Arrays.sort(edges);
        // Kruskal!
        double total = 0;
        for (int i = 0; i < edges.length; i++) {// edges를 돌면서
            int x = edges[i].st;
            int y = edges[i].ed;
            if (find(x) != find(y)) {
                union(x, y);
                total += edges[i].dist;
            }
        }
        System.out.println(String.format("%.2f", total));
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public static double cal(int x1, int y1, int x2, int y2) {
        double A = Math.pow(x1 - x2, 2);
        double B = Math.pow(y1 - y2, 2);
        return Math.sqrt(A + B);
    }
}
