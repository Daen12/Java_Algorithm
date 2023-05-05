import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q18428_감시피하기_gold5 {
    // 0 : 공백, 1 : 학생, 2 : 선생님, -1 : 놓을수 있는 자리
    static int N;
    static int[][] map;
    static String answer = "";
    static List<int[]> list;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        list = new ArrayList<>();
        N = in.nextInt();
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = in.next().charAt(0);
                if (val == 'X') {
                    map[r][c] = 0;
                } else if (val == 'S') { // 학생 인덱스는 따로 보관
                    map[r][c] = 1;
                    list.add(new int[] { r, c });
                } else {
                    map[r][c] = 2;
                }
            }
        } // map 인풋 완료.

        answer = "NO";
        BackTracking(0, 0, 0);
        System.out.println(answer);

    }

    public static void BackTracking(int r, int c, int cnt) {
        // 개수가 3개 이상일때 : 검사해서 감시 피하기 불가능하면 리턴(불리언 함수짜기)
        if (cnt == 3) {
            if (isStudentSafe()) {
                answer = "YES";
            }
            return;
        }
        // 다음 검사 : C+1
        // 범위 벗어나면 R+1
        if (c >= N) {
            r += 1;
            c = 0;
        }
        // R도 범위 벗어나면 리턴
        if (r >= N)
            return;

        // 해당 자리에 놓을 수 있으면 장애물 놓기
        if (map[r][c] == 0) {
            map[r][c] = 3;
            BackTracking(r, c + 1, cnt + 1);
            // 장애물 빼기
            map[r][c] = 0;
        }
        BackTracking(r, c + 1, cnt);

    }

    public static boolean isStudentSafe() {
        // list안의 좌표는 학생들의 좌표.
        // 학생마다 상하좌우 돌면서
        // 3발견 시 break,(장애물)
        // 2선생님 발견 시 false
        for (int i = 0; i < list.size(); i++) {
            int R = list.get(i)[0];
            // System.out.println(R);
            int C = list.get(i)[1];
            // System.out.println(C);

            for (int d = 0; d < 4; d++) {
                int t = 1;
                while (true) {
                    int nr = R + dr[d] * t;
                    int nc = C + dc[d] * t;

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                        break;

                    if (map[nr][nc] == 3)
                        break;// 장애물 -> 방향전환
                    if (map[nr][nc] == 2)
                        return false;// 선생님 -> not safe
                    t++;
                }
            }
            // 여기까지 오면 한 학생이 safe
        }
        // 여기까지 오면 모든 학생이 safe ->
        return true;
    }
}
