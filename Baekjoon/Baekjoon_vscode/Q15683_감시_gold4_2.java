import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q15683_감시_gold4_2 {
    // 입력받고
    // 각 번호에 대해 모든 경우의 수 만들기
    // 기존 사각지대보다 많아지면 가지치기(?)
    // 1은 한방향, 2는 두방향, 3은 직각, 4는 세방향, 5는 모든방향
    // 6은 벽
    // 회전은 항상 90도 방향으로 가능.
    static int N, M, maxCnt;
    static int[][] map, mapCopy, Status;
    static List<int[]> cctv, five;
    static int[] dr = { 0, 1, 0, -1 }; // 오른, 아래, 왼, 위 순서
    static int[] dc = { 1, 0, -1, 0 };
    static int[][] two, three, four;
    static int[] one;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        map = new int[N][M];

        cctv = new ArrayList<int[]>();
        five = new ArrayList<int[]>();
        four = new int[][] { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } };
        three = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
        two = new int[][] { { 0, 2 }, { 1, 3 } };
        one = new int[] { 1, 2, 3, 4 };

        // Status = new int[N][M];
        int walls = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == 5) {
                    five.add(new int[] { i, j });
                } else if (map[i][j] != 6 && map[i][j] != 0) {
                    cctv.add(new int[] { map[i][j], i, j });
                } else if (map[i][j] == 6) {
                    walls++;
                }
            }
        }

        int fives = 0;
        if (five.size() != 0) {
            for (int i = 0; i < five.size(); i++) {
                int r = five.get(i)[0];
                int c = five.get(i)[1];
                for (int j = 0; j < 4; j++) {
                    fives += shoot(r, c, j);
                }
            }
        }

        maxCnt = 0;
        watch(0, map, 0);
        System.out.println(N * M - maxCnt - cctv.size() - walls - fives - five.size()); // 36 - 6 - 2 - 2 -

    }

    public static void makeMapCopy(int[][] map) {
        mapCopy = new int[N][M];
        for (int j = 0; j < N; j++) {
            mapCopy[j] = map[j].clone();
        }
    }

    public static void watch(int seq, int[][] map, int cnt) {
        if (seq == cctv.size()) {
            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
            return;
        }

        int cctvNum = cctv.get(seq)[0];// cctv 번호
        int R = cctv.get(seq)[1];// 인덱스
        int C = cctv.get(seq)[2];

        // map copy
        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            mapCopy[i] = map[i].clone();
        }
        // cnt copy
        int cntCopy = cnt;

        if (cctvNum == 1) {
            // map 원상복귀
            for (int i = 0; i < one.length; i++) {
                for (int j = 0; j < N; j++) {
                    map[j] = mapCopy[j].clone();
                }
                // cnt 원상복귀
                cnt = cntCopy;

                cnt += shoot(R, C, i); // 한 경우의 수 완성
                watch(seq + 1, map, cnt);
            }

        } else if (cctvNum == 2) {

            for (int i = 0; i < two.length; i++) {
                // map 원상복귀
                for (int j = 0; j < N; j++) {
                    map[j] = mapCopy[j].clone();
                }
                // cnt 원상복귀
                cnt = cntCopy;

                for (int j = 0; j < 2; j++) {
                    cnt += shoot(R, C, two[i][j]);
                } // 한 경우의 수 완성
                watch(seq + 1, map, cnt);
            }

        } else if (cctvNum == 3) {
            for (int i = 0; i < three.length; i++) {
                // map 원상복귀
                for (int j = 0; j < N; j++) {
                    map[j] = mapCopy[j].clone();
                }
                // cnt 원상복귀
                cnt = cntCopy;

                for (int j = 0; j < 2; j++) {
                    cnt += shoot(R, C, three[i][j]);
                }
                watch(seq + 1, map, cnt);
            }

        } else if (cctvNum == 4) {
            for (int i = 0; i < four.length; i++) {
                // System.out.println("dir equals " + i);
                // map 원상복귀
                for (int j = 0; j < N; j++) {
                    map[j] = mapCopy[j].clone();
                }
                // cnt 원상복귀
                cnt = cntCopy;

                for (int j = 0; j < 3; j++) {
                    cnt += shoot(R, C, four[i][j]);
                }
                watch(seq + 1, map, cnt);
            }
        }
    }

    public static int shoot(int R, int C, int dir) {
        int cnt = 0;
        int t = 1;
        while (true) {
            int nr = R + dr[dir] * t; // 1
            int nc = C + dc[dir] * t; // 0
            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                return cnt;
            // 벽을 만나면 리턴
            if (map[nr][nc] == 6)
                return cnt;
            // cctv만나거나 이미 감시한 곳 건너뛰기
            if (map[nr][nc] != 0 && map[nr][nc] != 9) {
                t++;
                continue;
            }
            if (map[nr][nc] != 9) {
                map[nr][nc] = 9;
                cnt++;
            }
            t++;
        }

    }

}
