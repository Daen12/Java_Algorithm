import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2563_색종이2_silver4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		int[] x = new int[T];
		int[] y = new int[T];
		for (int t = 0; t < T; t++) {
			x[t] = in.nextInt();
			y[t] = in.nextInt();
		}
		// x [ 3, 15 5]
		// y [7, 7, 2]
		// (3,7) ~ (13, 17)

		// 다 1 넣어주기
		int[][] coloredPapers = new int[100][100]; // 0
		for (int i = 0; i < T; i++) {
			for (int r = y[i]; r < y[i] + 10; r++) {
				for (int c = x[i]; c < x[i] + 10; c++) {
					coloredPapers[r][c] = 1;
				}
			}
		}
		// 4방이 1이면 가장자리가 아님.
		// 4방 중 0의 갯수 = 둘레!

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int line = 0;

		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (coloredPapers[r][c] == 1) {
					// 검은 종이이며 가장자리에 위치해있으면 line++
					if(r==0 || r==99){
						if(c==0 || c==99){
							line++;
						}
						line++;
					} else if (c==0 || c==99){
						line++;
					}
				}
				// 하나의 인덱스에 대해서
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr >= 100 || nr < 0 || nc >= 100 || nc < 0)
						continue;
					// if(coloredPapers[r][c] == 1 && coloredPapers[nr][nc]==0) line++;
					if (coloredPapers[r][c] == 0 && coloredPapers[nr][nc] == 1)
						line++;
					
				}
			}
		}

		System.out.println(line);
	}
}
