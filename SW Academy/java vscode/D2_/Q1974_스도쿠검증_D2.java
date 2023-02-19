import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q1974_스도쿠검증_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int[][] tsudoku = new int[9][9];

            // 스도쿠에 숫자를 담기
            for (int r = 0; r < 9; r++) {
                String[] line = br.readLine().split(" ");
                for (int c = 0; c < 9; c++) {
                    tsudoku[r][c] = Integer.parseInt(line[c]);
                }
            }
            // 정답 변수 = answer
            int answer = 1;
            // 가로세로 체크
            for (int r = 0; r < 9; r++) {
                int[] R = { 1, 1, 1, 4, 4, 4, 7, 7, 7 };
                int[] C = { 1, 4, 7, 1, 4, 7, 1, 4, 7 };
                // 세트 만들기
                HashSet<Integer> rowSet = new HashSet<Integer>();
                HashSet<Integer> colSet = new HashSet<Integer>();
                HashSet<Integer> roundSet = new HashSet<Integer>();

                for (int c = 0; c < 9; c++) {
                    // 세트에 가로세로 값 추가하기
                    rowSet.add(tsudoku[r][c]);
                    colSet.add(tsudoku[c][r]);

                    // 8방 체크!
                    int[] dr = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
                    int[] dc = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
                    // 여기서 타겟 인덱스가 정해짐
                    // 8방 확인하고 값 세트에 넣기
                    int roundNum = tsudoku[R[r] + dr[c]][C[r] + dc[c]];
                    roundSet.add(roundNum);

                }

                // 세트이므로 중복제거됨. 제거된 숫자가 하나라도 9가 아니라면 스도쿠 아님.
                if (rowSet.size() != 9 || colSet.size() != 9 || roundSet.size() != 9) {
                    answer = 0;
                    break; // 아니면 틀림
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
