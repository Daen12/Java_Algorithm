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
    static int N, M;
    static int[][] map;
    static List<int[]> five, four, three, two, one = new ArrayList<int[]>();
    static int[] dr = { 0, 1, 0, -1 }; // 오른, 아래, 왼, 위 순서
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        map = new int[N][M];
        // arraylist 초기화
        // for(int i=0; i<64; i++){
        // five.get(i) = new int[2];
        // }

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
        for (int[] l : map) {
            System.out.println(Arrays.toString(l));
        }
        System.out.println(five.size());
        // five는 고정이므로 있다면 감시표시!
        if (five.size() != 0) {
            for (int i = 0; i < five.size(); i++) {
                int r = five.get(i)[0];
                int c = five.get(i)[1];
                map[r][c] = 9;
            }
        }
        // 4에서 최대 감시방향(=맵 상태) 구하기

        // TEST
        shoot(0, 0, 1);
        for (int[] l : map) {
            System.out.println(l);
        }
    }

    public static void checkFour(int seq, int cnt) {
        // seq에 따라 cnt값 최대로...

    }

    public static void shoot(int R, int C, int dir) {
        int t = 1;
        while (true) {
            int nr = R + dr[dir];
            int nc = C + dc[dir];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                return;
            // 벽을 만나면 리턴
            if (map[nr][nc] == 6)
                return;
            // cctv만나면 건너뛰기
            if (map[nr][nc] != 0)
                continue;

            map[nr][nc] = 9;
            t++;
        }

    }

}
