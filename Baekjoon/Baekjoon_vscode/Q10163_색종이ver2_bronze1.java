
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10163_색종이ver2_bronze1 {
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
		int[][][] maps = new int[T][1001][1001];
		for (int t = 0; t < T; t++) {
			// 새로운 맵 생성
			int[][] map = new int[1001][1001];
			// t에 해당하는 좌표들 1로 채워주기
			for (int r = R[t]; r < R[t] + y[t]; r++) {
				for (int c = C[t]; c < C[t] + x[t]; c++) {
					map[r][c] = 1;
				}
			}
			maps[t] = map;
			// for (int[] line : map) {
			// System.out.println(Arrays.toString(line));
			// }
		}

		// maps에 들어있는 맵들을 꺼내서, 오버랩되는 부분들 0으로 바꿔주기
		for (int t = 0; t < T; t++) {
			int[][] map = maps[t]; // 덮여질 맵
			for (int s = t + 1; s < T; s++) { // 각각의 덮을 맵에 대해서
				int[][] cover = maps[s];

				for (int i = 0; i < 1001; i++) {
					for (int j = 0; j < 1001; j++) {
						if (cover[i][j] == 1 && map[i][j] == 1) { // 덮을 색종이영역이 덮힐 색종이면
							map[i][j] = 0;
						}
					}
				}

			}
		}
		// maps에 들어있는 맵들 꺼내서 마지막 맵의 넓이 리턴

		for (int t = 0; t < T; t++) {
			int Sum = 0;
			for (int r = R[t]; r < R[t] + y[t]; r++) {
				for (int c = C[t]; c < C[t] + x[t]; c++) {
					Sum += maps[t][r][c];
				}
			}
			System.out.println(Sum);
		}
	}
}
