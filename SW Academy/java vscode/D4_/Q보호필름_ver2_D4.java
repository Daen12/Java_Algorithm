package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q보호필름_ver2_D4 {
	static int[][] Films;
	static int[][] FilmCopy;
	static int R, C, K;
	static int min;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			R = in.nextInt(); // 6
			C = in.nextInt(); // 8
			K = in.nextInt(); // 3
			Films = new int[R][C];
			visited = new boolean[R];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					Films[r][c] = in.nextInt();
				}
			}//필름 상태 입력
			
			min = Integer.MAX_VALUE;
			partialSet(0); // 배열에 가능한 부분집합 넣어주기.

			System.out.printf("#%d %b\n", t, min);
		}
	}

	public static void partialSet(int depth) {// 부분집합 구하기
		if(depth == R) {
			//깊이가 R에 도달했으면 가능한 부분집합 시나리오 한개 뽑은 상태.
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<R; i++) {
				if(visited[i]) {
					list.add(i);
					//i번째 행이 뽑힌 상태.
					//i번째 행을 A로 도핑하거나 - B로 도핑하거나
				
				}
			} //리스트에 행 다 담았으면
			putChemical(list);
			
		}
		visited[depth] = true;
		partialSet(depth+1);
		visited[depth] = false;
		partialSet(depth+1);

	}
	private static void putChemical(List<Integer> list) {
		FilmCopy = Films;
		for(int i=0; i<list.size(); i++) {//A를 투입하는 파트
			FilmCopy[i] = new int[C];
			for(int j=i+1; j<list.size(); j++) {
				FilmCopy[j] = new int[C]; //B를 투입하는 파트 = 1의 배열로 만들어주기
				for(int c=0; c<C; c++) {
					FilmCopy[j][c] = 1;
				}
			}
			//FilmCopy에 대해서 체크를 수행
			if(check()) {//만약 성능검사 통과하면, 바꾼 행의 수만큼 카운트에 더하기
				min = list.size() < min? list.size() : min;
			}
		}
	}

	public static void change(int r, int chemical) {
		
	}
	public static boolean check() {// 3
		int colComplete = 0;
		for (int r = 0; r < C; r++) {
			int flag = -1;
			int countA = 0;
			int countB = 0;
			for (int c = 0; c < R; c++) {
				if (c == 0) {
					flag = Films[0][r];
				}
				if (flag != Films[c][r]) {
					countA = 0;
					countB = 0;
					flag = Films[c][r];
				}
				if (Films[c][r] == 0 && flag == 0) {
					countA++;
					if (countA == K) {
						colComplete++;
						break;
					}
				} else if (Films[c][r] == 1 && flag == 1) {
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
