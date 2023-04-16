import java.util.Scanner;

public class Q1926_그림_silver1 {
    // DFS
    static int R, C, chunk, size;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();
        paper = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                paper[r][c] = in.nextInt();
            }
        }
        chunk = 0;
        int MaxSize = 0;// 그림 하나도 없을때 가장 넓은 그림의 넓이는 0이다.
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (paper[r][c] == 1 && !visited[r][c]) {
                    size = 0;
                    DFS(r, c);
                    MaxSize = Math.max(size, MaxSize);
                    chunk++;
                }
            }
        }
        System.out.println(chunk);
        System.out.println(MaxSize);
    }

    public static void DFS(int r, int c) {
        visited[r][c] = true;
        size++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (notBoundary(nr, nc))
                continue;
            if (!visited[nr][nc] && paper[nr][nc] == 1) {
                DFS(nr, nc);
            }
        }

    }

    public static boolean notBoundary(int r, int c) {
        return (r < 0 || c < 0 || r >= R || c >= C);
    }
}
