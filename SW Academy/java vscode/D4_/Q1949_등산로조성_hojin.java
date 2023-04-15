
import java.util.Scanner;

public class Q1949_등산로조성_hojin {
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int result;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][N];
            int top = 0;

            for (int r = 0; r < N; r++)
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                    top = Math.max(top, map[r][c]);
                }

            result = 0;

            for (int r = 0; r < N; r++)
                for (int c = 0; c < N; c++)
                    if (map[r][c] == top) {
                        visited = new boolean[N][N];
                        visited[r][c] = true;
                        dfs(r, c, 1, false);
                    }

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void dfs(int row, int col, int len, boolean flag) {
        result = Math.max(result, len);

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                continue;

            if (visited[nr][nc])
                continue;

            if (map[nr][nc] < map[row][col]) {
                visited[nr][nc] = true;
                dfs(nr, nc, len + 1, flag);
                visited[nr][nc] = false;
            } else if (!flag && map[nr][nc] - K < map[row][col]) {
                int temp = map[nr][nc];

                map[nr][nc] = map[row][col] - 1;
                visited[nr][nc] = true;
                dfs(nr, nc, len + 1, true);
                map[nr][nc] = temp;
                visited[nr][nc] = false;
            }
        }
    }
}
