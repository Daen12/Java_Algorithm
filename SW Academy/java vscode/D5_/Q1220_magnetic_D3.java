import java.util.Scanner;

public class Q1220_magnetic_D3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            // 1은 아래로 2는 위로
            // 그냥 세로로 읽으면서
            // 1 다음에 2가 나오면 count++
            int N = in.nextInt();
            // boolean[][] bool = new boolean[N][N]; //false
            int[][] map = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = in.nextInt();
                }
            }
            // 입력
            int total = 0;
            for (int r = 0; r < N; r++) {
                boolean isOneLast = false; // 각 열에 대해서 세로로 연산
                for (int c = 0; c < N; c++) {
                    if (map[c][r] == 1) {
                        isOneLast = true;
                    }
                    if (map[c][r] == 2 && isOneLast) {
                        total++;
                        isOneLast = false;
                    }
                }
            }
            System.out.printf("#%d %d\n", t, total);
        }
    }
}
