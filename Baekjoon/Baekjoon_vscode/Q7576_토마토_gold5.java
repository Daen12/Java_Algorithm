import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q7576_토마토_gold5 {
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { -1, 1, 0, 0 };
    static int[][] box;
    // tatic boolean[][] ripe;
    static int R, C, day;
    static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        C = in.nextInt();
        R = in.nextInt();
        List<int[]> list = new ArrayList<>();
        box = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                box[r][c] = in.nextInt();
                if (box[r][c] == 1) {
                    list.add(new int[] { r, c });
                }
            }
        }
        day = 0;
        queue = new LinkedList<>();
        // ripe = new boolean[R][C];
        for (int i = 0; i < list.size(); i++) {
            queue.offer(new int[] { list.get(i)[0], list.get(i)[1], 0 });// r,c,일수
            // box[list.get(i)[0]][list.get(i)[1]] = 1;
        }

        BFS();

        boolean allRipe = true;
        outer: for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (box[r][c] == 0) {
                    System.out.println(r + " " + c);
                    allRipe = false;
                    break outer;
                }
            }
        }
        if (allRipe) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll(); // 3,5,0
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d]; // 3
                int nc = curr[1] + dc[d]; // 4
                if (notValid(nr, nc) || box[nr][nc] == -1)// 범위 초과하거나 토마토 없는 공간의 경우
                    continue;
                if (box[nr][nc] == 0) {
                    queue.offer(new int[] { nr, nc, curr[2] + 1 });
                    day = Math.max(day, curr[2] + 1);
                    box[nr][nc] = 1;
                }
            }
        }
    }

    public static boolean notValid(int r, int c) {
        return (r < 0 || c < 0 || r >= R || c >= C);
    }
}
