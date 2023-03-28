package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q보호필름_ver5_D4 {
	//합격기준이 K이니까. K번 이상 바꾸지 않아도 됨!
	static int[][] Films;
	static int[][] FilmCopy;
	static int R, C, K;
	static int min;
	static boolean[] visited;
	static List<Integer> list;
	static boolean[] visited2;
	static int changeCnt;
	static int maxListSize;

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
			changeCnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					Films[r][c] = in.nextInt();
				}
			} // 필름 상태 입력

			min = Integer.MAX_VALUE;
			maxListSize = 0;
			partialSet(0); // 배열에 가능한 부분집합 넣어주기.
			for(int i=0; i<K; i++) {
				
			}
			System.out.printf("#%d %d\n", t, min);
		}
	}

	public static void partialSet(int depth) {// 부분집합 구하기
//		if(changeCnt == K) return;
//		if(maxListSize >= K) return;
		if (depth == R) {
			// 깊이가 R에 도달했으면 가능한 부분집합 시나리오 한개 뽑은 상태.
			list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				if (visited[i]) {
					list.add(i);
				}
			} // 리스트에 행 다 담았으면
			System.out.println(list);
			visited2 = new boolean[list.size()];
			putChemical(); //리스트 사이즈로 실행됨. 여기서 배열크기가 K이면 실행 후 종료.
			maxListSize= Math.max(maxListSize, list.size());
			return;
		}
		visited[depth] = true;
		partialSet(depth + 1);
		visited[depth] = false;
		partialSet(depth + 1);

	}

	private static void putChemical() {
//		if(changeCnt == K) return;
//		changeCnt++;
		for (int r = 0; r < R; r++) {
			FilmCopy[r] = Films[r].clone();
		}
		// 선별된 리스트에 대한 부분집합
		partialSet2(0);
	}
	
	public static void partialSet2(int depth) {
		if(depth == list.size()) {
			int[] B = new int[C];
			for (int k = 0; k < C; k++) {
				B[k] = 1;
			} // 1인 배열 만들어놓고
			for(int i=0; i<list.size(); i++) {
				if(visited2[i]) {//true이면 a로 
					FilmCopy[list.get(i)] = new int[C];
				} else {
					FilmCopy[list.get(i)] = B;
				}
			}
			if (check()) {// 만약 성능검사 통과하면, 바꾼 행의 수만큼 카운트에 더하기
				min = list.size() < min ? list.size() : min;
			}
			return;
		}
		visited2[depth] = true;
		partialSet2(depth+1);
		visited2[depth] = false;
		partialSet2(depth+1);
	}

	public static boolean check() {//검사 시 한번이라도 만족하지 않으면 더 검사할 필요가 없음.
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
