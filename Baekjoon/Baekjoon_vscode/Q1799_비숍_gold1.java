import java.util.Scanner;

public class Q1799_비숍_gold1 {
    // 대각선 방향 4방탐색
    static int[] dr = { -1, -1, 1, 1 };
    static int[] dc = { -1, 1, -1, 1 };
    static int N, bCnt, wCnt;
    static int[][] map;
    static boolean[][] blackVisited;
    static boolean[][] whiteVisited;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = in.nextInt();
            }
        } // 여기까지 입력
        bCnt = wCnt = 0;

        // blackVisited = new boolean[N][N];
        blackCheck(0, 0, 0);
        // whiteVisited = new boolean[N][N];
        whiteCheck(0, 1, 0);

        System.out.println(bCnt + wCnt);
    }

    private static void blackCheck(int R, int C, int cnt) {

        // 갱신
        bCnt = Math.max(bCnt, cnt);

        // 새로운 열이 범위를 벗어나면 좌표 조정
        if (C >= N) {
            R += 1;
            // 짝수행이면 0부터, 아님 1부터
            C = R % 2 == 0 ? 0 : 1;
        }
        if (R >= N)
            return;

        if (canPut(R, C)) {
            map[R][C] = 2;
            blackCheck(R, C + 2, cnt + 1);
            map[R][C] = 1; // 돌려놓기
        }
        blackCheck(R, C + 2, cnt);

    }

    private static void whiteCheck(int R, int C, int cnt) {

        // 갱신
        wCnt = Math.max(wCnt, cnt);

        // 새로운 열이 범위를 벗어나면 좌표 조정
        if (C >= N) {
            R += 1;
            // 짝수행이면 1부터, 아님 0부터
            C = R % 2 == 0 ? 1 : 0;
        }
        if (R >= N)
            return;

        if (canPut(R, C)) {
            map[R][C] = 2;
            whiteCheck(R, C + 2, cnt + 1);
            map[R][C] = 1; // 돌려놓기
        }
        // 해당 자리에 놓을 수 없으면 다음 자리로!
        // 위에서 해당 자리에 놓았어도 다시 원상복구 -> 다음 자리로
        whiteCheck(R, C + 2, cnt);

    }

    public static boolean canPut(int R, int C) {
        if (map[R][C] == 0)
            return false;

        for (int d = 0; d < 4; d++) {
            int t = 1;
            while (true) {
                int nr = R + dr[d] * t;
                int nc = C + dc[d] * t;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    break;
                if (map[nr][nc] == 2) {
                    return false;
                }
                t++;
            }
        }
        return true;
    }
}
