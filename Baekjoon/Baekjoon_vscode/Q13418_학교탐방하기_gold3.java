import java.util.Arrays;
import java.util.Scanner;

public class Q13418_학교탐방하기_gold3 {
    // Kruskal!
    // union - find
    // 간선이 주인공. 간선을 오름차순/내림차순 정렬 후 크루스칼 실행
    // 두 경우의 결과값의 차 산출

    static class Edge {
        int st;
        int ed;
        int val;

        public Edge(int st, int ed, int val) {
            this.st = st;
            this.ed = ed;
            this.val = val;
        }
    }

    static Edge[] edges;
    static int N, M;
    static int[] p;
    static int ans, pick;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();// 노드수
        M = in.nextInt();// 간선수
        // make-set
        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }
        // 입력받기
        edges = new Edge[M + 1];
        for (int i = 0; i < M + 1; i++) {
            int st = in.nextInt();
            int ed = in.nextInt();
            int val = Math.abs(in.nextInt() - 1);// 0이면 1, 1이면 0저장
            edges[i] = new Edge(st, ed, val);
        }
        // 오름차순 정렬
        Arrays.sort(edges, (o1, o2) -> {
            return o1.val - o2.val;
        });
        // 크루스칼
        ans = 0;
        pick = 0;
        Kruskal();
        int first = (int) Math.pow(ans, 2);
        // 내림차순 정렬
        Arrays.sort(edges, (o1, o2) -> {
            return o2.val - o1.val;
        });
        // p 갱신
        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            p[i] = i;
        }
        // 크루스칼
        ans = 0;
        pick = 0;
        Kruskal();
        int second = (int) Math.pow(ans, 2);

        System.out.println(Math.abs(first - second));
    }

    public static void Kruskal() {
        for (int i = 0; i < M + 1; i++) {
            int x = edges[i].st;
            int y = edges[i].ed;
            if (find(x) != find(y)) {// 시작과 끝 노드의 조상노드가 같지 않으면
                union(x, y);// 연결하기
                ans += edges[i].val;// 그 간선의 값 더하기
                pick++;
            } // 조상노드가 모두 같다 = 연결되어있다
            if (pick == N)
                break;
        }
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public static void union(int x, int y) {
        p[find(y)] = find(x);
    }
}
