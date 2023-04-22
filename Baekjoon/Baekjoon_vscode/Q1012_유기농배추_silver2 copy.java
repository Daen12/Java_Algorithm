import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1012_유기농배추_silver2 {
    static int[][] map;
    static int M, N;
    static boolean visited[][];
    static int[] dr = { 0, 1, -1, 0 };
    static int[] dc = { -1, 0, 0, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            M = in.nextInt(); // 10
            N = in.nextInt();// 8

            map = new int[N][M];

            int K = in.nextInt();

            for (int i = 0; i < K; i++) {
                int c = in.nextInt();
                int r = in.nextInt();
                map[r][c] = 1;
            }
            // for (int[] l : map) {
            // System.out.println(Arrays.toString(l));
            // }

            int cnt = 0;
            visited = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        BFS(r, c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int R = p[0];
            int C = p[1];

            for (int d = 0; d < 4; d++) {
                int nr = R + dr[d];
                int nc = C + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    queue.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
