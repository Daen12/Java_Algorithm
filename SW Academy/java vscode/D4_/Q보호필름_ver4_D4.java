package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q보호필름_ver4_D4 {
	static int[][] Films;
	static int[][] FilmCopy;
	static int R, C, K;
	static int min;
	static boolean[] visited;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			R = in.nextInt(); // 6
			C = in.nextInt(); // 8
			K = in.nextInt(); // 3
			Films = new int[R][C];
			FilmCopy = new int[R][C];
			visited = new boolean[R];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					Films[r][c] = in.nextInt();
				}
			} // 필름 상태 입력

			min = Integer.MAX_VALUE;
			partialSet(0); // 배열에 가능한 부분집합 넣어주기.
			System.out.printf("#%d %d\n", t, min);
		}
	}

	public static void partialSet(int depth) {// 부분집합 구하기
		if (depth == R) {
			// 깊이가 R에 도달했으면 가능한 부분집합 시나리오 한개 뽑은 상태.
			list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				if (visited[i]) {
					list.add(i);
				}
			} // 리스트에 행 다 담았으면
			putChemical();
			return;
		}
		visited[depth] = true;
		partialSet(depth + 1);
		visited[depth] = false;
		partialSet(depth + 1);

	}

	private static void putChemical() {
		for (int r = 0; r < R; r++) {
			FilmCopy[r] = Films[r].clone();
		}
		// 선별된 리스트에 대한 비트마스킹
		for (int i = 0; i < (1 << list.size()); i++) {// 리스트의 개수에 대한 모든 경우의 수
			int[] temp = new int[list.size()];
			for (int j = 0; j < list.size(); j++) {
				if ((i & (1 << j)) > 0) {// j번째 수가 비트에 있으면
					temp[j] = 1;
				}
			}
			int[] B = new int[C];
			for (int k = 0; k < C; k++) {
				B[k] = 1;
			} // 1인 배열 만들어놓고
				// list.size() = 3일때 temp = {0,1,1} 이런식으로 뽑힘.
				// 1이면 리스트의 해당자리 B로 칠하고, 0이면 리스트의 해당 자리의 숫자 행 A로 칠하도록 하기
			for (int j = 0; j < list.size(); j++) {
				if (temp[j] == 0) { // A
					FilmCopy[list.get(j)] = new int[C];
				} else { // B
					FilmCopy[list.get(j)] = B;
				}
			}
			if (check()) {// 만약 성능검사 통과하면, 바꾼 행의 수만큼 카운트에 더하기
				min = list.size() < min ? list.size() : min;
			}
		}
	}

	public static boolean check() {// 3
		int colComplete = 0;
		for (int r = 0; r < C; r++) {
			int flag = -1;
			int countA = 0;
			int countB = 0;
			for (int c = 0; c < R; c++) {
				if (c == 0) {
					flag = FilmCopy[0][r];
				}
				if (flag != FilmCopy[c][r]) {
					countA = 0;
					countB = 0;
					flag = FilmCopy[c][r];
				}
				if (FilmCopy[c][r] == 0 && flag == 0) {
					countA++;
					if (countA == K) {
						colComplete++;
						break;
					}
				} else if (FilmCopy[c][r] == 1 && flag == 1) {
					countB++;
					if (countB == K) {
						colComplete++;
						break;
					}
				}
			}
		}
		// 만약 colComplete의 값이 칼럼개수와 일치하면 모두 통과한것이므로 리턴 true
		if (colComplete == C) {
			return true;
		} else {
			return false;
		}
	}
}
