import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q15683_감시_gold4 {
    // 입력받고
    // 각 번호에 대해 모든 경우의 수 만들기
    // 기존 사각지대보다 많아지면 가지치기(?)
    // 1은 한방향, 2는 두방향, 3은 직각, 4는 세방향, 5는 모든방향
    // 6은 벽
    // 회전은 항상 90도 방향으로 가능.
    static int N, M, maxCnt;
    static int[][] map, mapCopy, fourStatus;
    static List<int[]> five, four, three, two, one;
    static int[] dr = { 0, 1, 0, -1 }; // 오른, 아래, 왼, 위 순서
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        map = new int[N][M];

        five = new ArrayList<int[]>();
        four = new ArrayList<int[]>();
        three = new ArrayList<int[]>();
        two = new ArrayList<int[]>();
        one = new ArrayList<int[]>();

        fourStatus = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == 5) {
                    five.add(new int[] { i, j });
                } else if (map[i][j] == 4) {
                    four.add(new int[] { i, j });
                } else if (map[i][j] == 3) {
                    three.add(new int[] { i, j });
                } else if (map[i][j] == 2) {
                    two.add(new int[] { i, j });
                } else if (map[i][j] == 1) {
                    one.add(new int[] { i, j });
                }
            }
        }

        // for (int[] l : map) {
        // System.out.println(Arrays.toString(l));
        // }
        // five는 고정이므로 있다면 감시표시!
        if (five.size() != 0) {
            for (int i = 0; i < five.size(); i++) {
                int r = five.get(i)[0];
                int c = five.get(i)[1];
                map[r][c] = 9;
                System.out.println("here");
            }
        }
        // 4에서 최대 감시방향(=맵 상태) 구하기

        // TEST
        maxCnt = 0;
        // for (int[] l : four) {
        // System.out.print(Arrays.toString(l) + " ");
        // }
        // shoot(0, 0, 1);
        // for (int[] l : map) {
        // System.out.println(Arrays.toString(l));
        // }

        checkFour(0, map, 0);
        System.out.println(maxCnt);

    }

    // public static void checkkFour(int seq, int cnt) {
    // // seq에 따라 cnt값 최대로...
    // // 012 123 230 301

    // while (seq < four.size()) {
    // int R = four.get(seq)[0];
    // int C = four.get(seq)[1];
    // makeMapCopy();
    // // 첫번째 경우
    // int max = shoot(R, C, 0) + shoot(R, C, 1) + shoot(R, C, 2);
    // // 두번째 경우
    // makeMapCopy();
    // int compare1 = shoot(R, C, 1) + shoot(R, C, 2) + shoot(R, C, 3);
    // max = Math.max(max, compare1);
    // // 3번째 경우
    // makeMapCopy();
    // int compare2 = shoot(R, C, 0) + shoot(R, C, 2) + shoot(R, C, 3);
    // max = Math.max(max, compare2);
    // // 두번째 경우
    // makeMapCopy();
    // int compare3 = shoot(R, C, 1) + shoot(R, C, 0) + shoot(R, C, 3);
    // max = Math.max(max, compare3);
    // }
    // }
    public static void makeMapCopy(int[][] map) {
        mapCopy = new int[N][M];
        for (int j = 0; j < N; j++) {
            mapCopy[j] = map[j].clone();
        }
    }

    public static void checkFour(int seq, int[][] map, int cnt) {
        // maxCnt보다 cnt가 커지면 리턴시키기
        if (seq == four.size()) {
            for (int[] line : map) {
                System.out.println(Arrays.toString(line));
            }
            System.out.println("cnt :" + cnt);

            if (maxCnt < cnt) {
                for (int i = 0; i < N; i++) {
                    fourStatus[i] = map[i].clone();
                }
                maxCnt = cnt;
            }
            return;
        }

        int R = four.get(seq)[0];
        int C = four.get(seq)[1];

        // map copy
        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            mapCopy[i] = map[i].clone();
        }
        // makeMapCopy(map);
        // cnt copy
        int cntCopy = cnt;

        for (int dir = 0; dir < 4; dir++) {
            // map 원상복귀
            for (int i = 0; i < N; i++) {
                map[i] = mapCopy[i].clone();
            }
            // cnt 원상복귀
            cnt = cntCopy;

            System.out.println("dir equals " + dir);
            for (int i = 0; i < 4; i++) {
                if (i == dir)
                    continue; // dir빼고
                cnt += shoot(R, C, i);
            } // 한 경우의 수 map에 그리기 완성

            // for (int[] line : map) {
            // System.out.println(Arrays.toString(line));
            // }

            // 다음 순서로 넘어가기
            checkFour(seq + 1, map, cnt);
            System.out.println("Here!");

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
            if (map[nr][nc] != 0 && map[nr][nc] != 9)
                continue;
            if (map[nr][nc] != 9) {
                map[nr][nc] = 9;
                cnt++;
            }
            t++;
        }

    }

}
