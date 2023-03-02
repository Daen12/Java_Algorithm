
import java.util.Scanner;

public class Q1733_J_오목 {
	static int[][] map;
	// static boolean[][] bool = new boolean[19][19];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		map = new int[19][19];
		for (int r = 0; r < 19; r++) { // 0-18까지
			for (int c = 0; c < 19; c++) {
				map[r][c] = in.nextInt();
			}
		}
		// 입력
		// 왼쪽위에서 오른쪽아래로 scan.
		outer: for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if (map[c][r] == 1) { // 1을 만나면
					if (checkOmok(c, r, 1)) {
						System.out.println(1);
						System.out.println((c + 1) + " " + (r + 1));
						break outer;
					}
					;
				}
				if (map[c][r] == 2) { // 2를 만나면
					if (checkOmok(c, r, 2)) {
						System.out.println(2);
						System.out.println((c + 1) + " " + (r + 1));
						break outer;
					}
				}
				if (r == 18 && c == 18) {
					System.out.println(0);
				}
			}
		}

	}

	public static boolean checkOmok(int r, int c, int N) { // 3,2,1
		// int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
		// int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
		int[] dc = { 1, 1, 1, 0 };
		int[] dr = { -1, 0, 1, 1 };
		int[] Dc = { -1, -1, -1, 0 };
		int[] Dr = { 1, 0, -1, -1 };

		for (int i = 0; i < 4; i++) {// 각 방향에 대해서
			int k = 1;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19)
				continue;
			while (map[nr][nc] == N) {// 방향이 맞으면 그방향으로 계속 가기
				k++; // 2
				nr = r + (dr[i] * k);
				nc = c + (dc[i] * k);
				if (nr < 0 || nr >= 19 || nc < 0 || nc >= 19)
					break;
			}
			// N이 아니면 탈출.
			if (k == 5) { // 5를 맞춤.
				boolean isExists = false;
				int ir = r + Dr[i]; // 0 2
				int ic = c + Dc[i];
				if (ir >= 0 && ir < 19 && ic >= 0 && ic < 19) {
					if (map[ir][ic] == N) {
						isExists = true;
					}
				}
				if (!isExists)
					return true;
			}
			// } else {
			// int ni = i - 4;
			// int ir = r + dr[ni];
			// int ic = c + dc[ni];
			// if (ir < 0 || ir >= 19 || ic < 0 || ic >= 19)
			// break;
			// if (map[ir][ic] == N) {
			// isExists = true;
			// }
			// }
		}
		return false;
	}
}
