import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q15686_치킨배달_gold5 {
    // 브루트포스 & 백트래킹
    // 치킨집을 n개 고르고
    // 조합으로 치킨집 구한 후
    // 각 집마다 구한 조합n개 중 최솟값 거리 구해서 누적 합 산출
    static int N, M, chi, ans;
    static int[][] map;
    static List<int[]> houses, chickens;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt(); // chickens
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        map = new int[N][N];
        chi = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = in.nextInt();
                if (map[r][c] == 1)
                    houses.add(new int[] { r, c });
                else if (map[r][c] == 2) {
                    chi++;
                    chickens.add(new int[] { r, c });
                }
            }
        }
        ans = Integer.MAX_VALUE;
        visited = new boolean[chi];
        BackTracking(0, 0);
        System.out.println(ans);
    }

    public static void BackTracking(int depth, int idx) {
        if (depth == M) {
            int[][] sel = new int[M][2];
            int j = 0;
            for (int i = 0; i < chi; i++) {// 몇번째 치킨집이 선정되었는가
                if (visited[i]) {
                    sel[j++] = chickens.get(i);
                }
            }
            int sum = 0;
            for (int i = 0; i < houses.size(); i++) {// home
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {// chicken
                    min = Math.min(min, cal(houses.get(i)[0], houses.get(i)[1], sel[k][0], sel[k][1]));
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = idx; i < chi; i++) {
            visited[i] = true;
            BackTracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int cal(int hR, int hC, int cR, int cC) {
        return Math.abs(hR - cR) + Math.abs(hC - cC);
    }

}
