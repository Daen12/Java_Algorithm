
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10163_색종이ver3_bronze1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] C = new int[T];
		int[] R = new int[T];
		int[] x = new int[T];
		int[] y = new int[T];
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C[t] = Integer.parseInt(st.nextToken());
			R[t] = Integer.parseInt(st.nextToken());
			x[t] = Integer.parseInt(st.nextToken());
			y[t] = Integer.parseInt(st.nextToken());

		}
		// 여기까지 배열화
		// 새로운 맵 생성
		int[][] map = new int[1001][1001];
		for (int t = 0; t < T; t++) {
			// t에 해당하는 좌표들 1로 채워주기
			for (int r = R[t]; r < R[t] + y[t]; r++) {
				for (int c = C[t]; c < C[t] + x[t]; c++) {
					map[r][c] = t + 1;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			int Sum = 0;
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (map[r][c] == t + 1)
						Sum++;
				}
			}
			System.out.println(Sum);
		}
	}
}
