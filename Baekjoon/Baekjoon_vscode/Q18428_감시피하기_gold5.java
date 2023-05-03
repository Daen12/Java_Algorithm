import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q18428_감시피하기_gold5 {
    // 0 : 공백, 1 : 학생, 2 : 선생님, -1 : 놓을수 있는 자리
    static int N;
    static int[][] map;
    static List<int[]> list;

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

    }

    public static void BackTracking() {
        // 개수가 3개 이상일때 : 검사해서 감시 피하기 불가능하면 리턴(불리언 함수짜기)

        // 그 자리가 선생님이거나 학생일때 리턴

        // 놓는 조건 : 학생이 선생님을 피할 수 있는 자리

        // 다음 검사 : C+1
        // 범위 벗어나면 R+1
        // R도 범위 벗어나면 리턴

    }

    public static boolean isStudentSafe() {

    }
}
