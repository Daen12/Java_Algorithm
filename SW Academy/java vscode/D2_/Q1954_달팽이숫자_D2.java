import java.util.Scanner;

public class Q1954_달팽이숫자_D2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            // 숫자를 입력받는다.
            int N = in.nextInt();
            // 입력받은 숫자 크기의 배열을 만든다.
            int[][] map = new int[N][N];
            boolean[][] bool = new boolean[N][N];
            // 방향 전환용 배열을 만든다.
            int[] dc = { 1, 0, -1, 0 }; // 01230123...
            int[] dr = { 0, 1, 0, -1 };
            int num = 1;
            int dir = 0;
            int r = 0;
            int c = 0;
            map[r][c] = num++;
            bool[r][c] = true;
            while (num <= N * N) {
                r = r + dr[dir % 4];
                c = c + dc[dir % 4];
                // 새로운 인덱스가 범위 안에 있고(AND) 안갔던 곳이면 채우기
                if (r < N && 0 <= r && c < N && 0 <= c && !bool[r][c]) {
                    map[r][c] = num++;
                    bool[r][c] = true;
                } else {
                    // 만약 갔던 곳이거나 범위밖이면 r과 c 이전으로
                    // 방향 틀기
                    r -= dr[dir % 4]; // 0
                    c -= dc[dir % 4]; // 2
                    dir++;
                }
            }
            System.out.printf("#%d\n", t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
