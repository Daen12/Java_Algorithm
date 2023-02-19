import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1961_숫자배열회전_D2 {
    public static void main(String[] args) throws IOException {
        // 행렬 3개 만들어서 각각 프린트하기.
        // 먼저 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[][] original = new String[N][N];
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    original[r][c] = st.nextToken();
                }
            }

            String[][] first = new String[N][N];
            String[][] second = new String[N][N];
            String[][] third = new String[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    first[r][c] = original[N - 1 - c][r];
                    second[r][c] = original[N - 1 - r][N - 1 - c];
                    third[r][c] = original[c][N - 1 - r];
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                System.out.print(String.join("", first[i]) + " ");
                System.out.print(String.join("", second[i]) + " ");
                System.out.print(String.join("", third[i]) + "\n");
            }

        }
    }
}
