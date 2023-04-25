import java.util.Scanner;

//https://mintheon.com/devlog/2021/08/29/%EB%B0%B1%EC%A4%80-1799-%EB%B9%84%EC%88%8D-(Java)/
public class Q1799_비숍_gold1 {
    // 대각선 방향 4방탐색
    static int[] dr = { -1, -1, 1, 1 };
    static int[] dc = { -1, 1, -1, 1 };
    static int[] pr = { -1, 0, 1, 0 };
    static int[] pc = { 0, -1, 0, 1 };
    static int N, maxCnt;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = in.nextInt();
            }
        }
        visited = new boolean[N][N];
        maxCnt = 0;
        BackTracking(0, 0, 0);
        System.out.println(maxCnt);
    }

    private static void BackTracking(int R, int C, int cnt) {
        // 갱신
        maxCnt = Math.max(maxCnt, cnt);
        // 놓기전에 4방으로 다른 비숍이 있는지 확인
        // boolean flag = false;
        for (int d = 0; d < 4; d++) {
            int t = 1;
            while (true) {
                int nr = R + dr[d] * t;
                int nc = C + dc[d] * t;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    break;
                if (map[nr][nc] == 2) {
                    // flag = true;
                    return;
                    // break outer;
                }
                t++;
            }
        }
        // 4방으로 비숍이 없음
        // 다음 놓을 수 있는 자리 = 상하좌우 4방 중 한 곳
        for (int d = 0; d < 4; d++) {
            int t = 1;
            while (true) {
                int nr = R + pr[d] * t;
                int nc = C + pc[d] * t;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    break;

                if (map[nr][nc] == 1) {// 놓을 수 있다면
                    map[nr][nc] = 2;// 놓고
                    BackTracking(nr, nc, cnt + 1);
                    map[nr][nc] = 1;// 빼고
                    BackTracking(nr, nc, cnt);
                }
                t++;
            }
        }
    }
}