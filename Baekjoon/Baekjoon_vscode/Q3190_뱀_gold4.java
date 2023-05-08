import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3190_뱀_gold4 {
    static int[][] map;
    static int N, R, C, dir;
    // 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위
    static int[][] direction = { { 3, 1 }, { 0, 2 }, { 1, 3 }, { 2, 0 } };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int M = in.nextInt();

        for (int i = 0; i < M; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            map[r - 1][c - 1] = 2;
        } // 맵 저장 완료

        R = C = 0;
        dir = 0;

        int L = in.nextInt();
        //맵에 초와 방향 저장하기
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int sec = in.nextInt();
            char dir = in.next().charAt(0);
            map.put(sec, dir);
        }

        while () {

        }

    }

    public static void move() {

    }

    public static void up() {
        R--;
    }
}
