import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3190_뱀_gold4 {
    static int[][] map;
    static int N, R, C, dir;
    // 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위
    static int[][] direction = { { 3, 1 }, { 0, 2 }, { 1, 3 }, { 2, 0 } };
    static boolean stop = false;
    static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int M = in.nextInt();
        map = new int[N][N];
        for (int i = 0; i < M; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            map[r - 1][c - 1] = 2;
        } // 맵 저장 완료

        int L = in.nextInt();
        // 맵에 초와 방향 저장하기
        Map<Integer, Character> timeTracker = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int sec = in.nextInt();
            char dir = in.next().charAt(0);
            timeTracker.put(sec, dir);
        }

        int t = 0;
        R = C = 0;
        deque.push(new int[] { R, C });
        dir = 0;
        while (!stop) { // stop = true이면 루프 탈출
            move(dir);
            t++;
            // 만약 해당 초가 방향을 바꿔야 하는 초라면 dir바꿔주기
            if (timeTracker.containsKey(t)) {
                char val = timeTracker.get(t);
                if (val == 'L') {
                    dir = direction[dir][0];
                } else {
                    dir = direction[dir][1];
                }
            }
        }
        System.out.println(t);

    }

    public static void move(int dir) {
        if (dir == 0) {
            C++;
        } else if (dir == 1) {
            R++;
        } else if (dir == 2) {
            C--;
        } else {
            R--;
        }
        // 방향전환 후

        if (hitWall() || hitMyself()) {
            stop = true;
            return; // 게임종료

        } else if (map[R][C] == 2) { // 사과를 만나면
            map[R][C] = 0;// 사과 먹었으니 map에 있는 사과 없애주기
            deque.addFirst(new int[] { R, C });// 꼬리 안없애고 머리 늘리기

        } else { // 사과를 안만나면
            deque.removeLast(); // 꼬리 빼주기
            deque.addFirst(new int[] { R, C });// 머리 늘리기
        }
    }

    static boolean hitMyself() {

        for (int[] arr : deque) {
            if (arr[0] == R && arr[1] == C) {
                return true;
            }
        }
        return false;
    }

    static boolean hitWall() {
        return (R < 0 || C < 0 || R >= N || C >= N);
    }
}
