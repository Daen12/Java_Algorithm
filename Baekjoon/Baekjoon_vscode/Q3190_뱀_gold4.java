import java.util.Scanner;

public class Q3190_뱀_gold4 {
    static int[][] map;
    static int N, R, C;
    // 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위
    static int[][] direction = { { 3, 1 }, { 0, 2 }, { 1, 3 }, { 2, 0 } };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int M = in.nextInt();

        for (int i = 0; i < M; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            map[r - 1][c - 1] = 1;
        } // 맵 저장 완료
        R = C = 0;
        int L = in.nextInt();
        for (int i = 0; i < L; i++) {
            int sec = in.nextInt();
            char dir = in.next().charAt(0);

        }

        while (true) {

        }

    }

    public static void up() {
        R--;
    }
}
