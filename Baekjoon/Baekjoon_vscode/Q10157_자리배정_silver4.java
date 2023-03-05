import java.util.Scanner;

class Q10157_자리배정_silver4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int C = in.nextInt(); // 7
        int R = in.nextInt(); // 6
        int num = in.nextInt(); // 11
        if (num <= R * C) {
            boolean[][] seats = new boolean[R][C];
            // 시작인덱스 = (0, R-1)
            // 방향 : 위, 오른쪽, 아래, 왼쪽
            int nr = R - 1; // 0
            int nc = 0; // 5
            seats[nr][nc] = true;
            int[] dc = { 0, 1, 0, -1 };
            int[] dr = { -1, 0, 1, 0 };
            int d = 0;
            int tempr = 0, tempc = 0;
            for (int i = 1; i < num; i++) {
                nr = nr + dr[d]; // 4
                nc = nc + dc[d]; // 0
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || seats[nr][nc]) { // 모서리를 만나거나 이미 true이면 방향 바꾸기
                    d = ++d % 4;
                    nr = tempr + dr[d];
                    nc = tempc + dc[d];
                    // if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                    // continue;
                    seats[nr][nc] = true;

                } else {
                    seats[nr][nc] = true;

                }
                tempr = nr; // 0
                tempc = nc; // 0
            }
            System.out.printf("%d %d", nc + 1, R - nr);
        } else {
            System.out.println(0);
        }
    }
}