import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q16234_인구이동 {
    static boolean[][] visited;
    static int N, L, M;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = in.nextInt(); // 20
        M = in.nextInt(); // 50

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = in.nextInt();
            }
        }

        int day = 0;
        // 바뀐 맵에서 더이상 국경 열일이 없을때까지 위 반복
        while (canOpen()) {
            day++;
            openBorder();
        }
        System.out.println(day);
    }

    public static boolean canOpen() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 4방탐색, 범위 안에 있으면 true 반환
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                        continue;
                    int abs = Math.abs(map[r][c] - map[nr][nc]);
                    if (L <= abs && abs <= M) {
                        return true;
                    }
                }
            }
        }
        // 다 돌아도 없으면 false 반환
        return false;
    }

    // 하루 동안 바뀌는 모습 구현!
    public static void openBorder() {
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c])
                    BFS(r, c);
            }
        }
    }

    // 사방탐색 -> 국경 허무는 함수 (BFS)
    public static void BFS(int R, int C) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        int cnt = 1;
        int total = map[R][C];

        queue.offer(new int[] { R, C });
        list.add(new int[] { R, C });
        visited[R][C] = true;

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int r = parent[0];
            // System.out.println(r);
            int c = parent[1];
            // System.out.println(c);

            for (int d = 0; d < 4; d++) {
                // 4방 인접국가의 차이가 L이상 R이하이면
                // queue에 담고 cnt++
                // 인구수 누적합
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                    continue;
                int abs = Math.abs(map[r][c] - map[nr][nc]);

                if (L <= abs && abs <= M) {
                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    list.add(new int[] { nr, nc });
                    cnt++;
                    total += map[nr][nc];
                }
            }
        }
        int newVal = total / cnt;
        for (int i = 0; i < list.size(); i++) {
            map[list.get(i)[0]][list.get(i)[1]] = newVal;
        }
    }
}
