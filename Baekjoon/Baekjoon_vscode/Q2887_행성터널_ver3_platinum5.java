import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2887_행성터널_ver3_platinum5 {
    static class planet {
        int x, y, z;

        public planet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class tunnel {
        int st, ed, dist;

        public tunnel(int st, int ed, int dist) {
            this.st = st;
            this.ed = ed;
            this.dist = dist;
        }
    }

    static planet[] planets;
    static tunnel[] tunnels;
    static int[] parent;
    static int N, minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        planets = new planet[N];
        for (int i = 0; i < N; i++) { // 0-N-1까지 행성번호 부여
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new planet(x, y, z);
        }
        // 모든 간선 잇는 경우의 수
        int p = N * (N - 1) / 2;
        tunnels = new tunnel[p];
        int t = 0;
        for (int j = 0; j < N - 1; j++) {// 3
            for (int k = j + 1; k < N; k++) {// 4
                tunnels[t++] = new tunnel(j, k, distance(planets[j], planets[k]));
            }
        }
        // for (tunnel T : tunnels) {
        // System.out.print(T.dist + " ");
        // }
        Arrays.sort(tunnels, new Comparator<tunnel>() {
            public int compare(tunnel o1, tunnel o2) {
                return o1.dist - o2.dist;
            }
        });// distance순서로 터널 배열 정렬 완료

        // make-set
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        // kruskal algorithm
        int minCost = 0;
        int pick = 0;
        for (int i = 0; i < p; i++) {
            int x = tunnels[i].st;
            int y = tunnels[i].ed;
            if (findSet(x) != findSet(y)) {
                union(x, y);
                minCost += tunnels[i].dist;
                pick++;
            }
            if (pick == N - 1)
                break;
        }

        System.out.println(minCost);
    }

    public static int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }

    public static int distance(planet p1, planet p2) {
        int x = Math.abs(p1.x - p2.x);
        int y = Math.abs(p1.y - p2.y);
        int z = Math.abs(p1.z - p2.z);
        int min = Math.min(Math.min(x, y), Math.min(y, z));
        return min;
    }
}
