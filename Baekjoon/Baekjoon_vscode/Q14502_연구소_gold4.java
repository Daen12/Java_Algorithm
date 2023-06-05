import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q14502_연구소_gold4 {
    static int[][] map;
    static int safeZone, N, M;
    static List<int[]> virus;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        map = new int[N][M];
        virus = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = in.nextInt();
                if (map[r][c] == 2) {
                    virus.add(new int[] { r, c });
                }
            }
        }

        int[][] mapCopy = new int[N][M];
        for (int r = 0; r < N; r++) {
            mapCopy[r] = map[r].clone();
        }

        int maxSafeZone = 0;

        // 0-N*M중 세개를 고르기
        for (int i = 0; i < N * M - 2; i++) {
            if (isWallOrVirus(i))
                continue; // 이미 벽이면 다음 포문으로

            for (int j = i + 1; j < N * M - 1; j++) {
                if (isWallOrVirus(j))
                    continue;

                for (int k = j + 1; k < N * M; k++) {
                    if (isWallOrVirus(k))
                        continue;
                    int[] list = new int[] { i, j, k };
                    // 벽 세우기
                    setWall(list);
                    spreadVirus();
                    // 세이프존 최댓값 갱신
                    maxSafeZone = Math.max(maxSafeZone, cntSafeZone());
                    // map 원상복구
                    for (int r = 0; r < N; r++) {
                        map[r] = mapCopy[r].clone();
                    }
                }
            }
        }

        System.out.println(maxSafeZone);

    }

    public static int cntSafeZone() {
        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static boolean isWallOrVirus(int num) {
        int r = num / M;
        int c = num - r * M;

        if (map[r][c] == 1 || map[r][c] == 2) {
            return true;
        }
        return false;
    }

    public static void setWall(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int num = list[i];
            int r = num / M;
            int c = num - r * M;

            map[r][c] = 1;
        }
    }

    public static void spreadVirus() {

        Queue<int[]> queue = new LinkedList<>();
        for (int[] node : virus) {
            queue.offer(node);
        }
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int[] par = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = par[0] + dr[d];
                int nc = par[1] + dc[d];
                // 범위를 벗어나면 스킵
                if (outsideBorder(nr, nc))
                    continue;
                // 벽이면 스킵
                if (map[nr][nc] != 0)
                    continue;

                queue.offer(new int[] { nr, nc });
                map[nr][nc] = 2;
            }
        }
    }

    public static boolean outsideBorder(int r, int c) {
        return (r < 0 || c < 0 || r >= N || c >= M);
    }

}
