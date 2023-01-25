package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class 배열2_실습3_ver1 {
	public static int r;
	public static int c;
	public static String[][] map;
	public static int N;
	
	public static boolean hasGreen(String pos) {
		// 상하좌우 왼위,오위,왼아래,오른아래
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//예외처리
			if(nr < 0 || nc < 0 || nr>=N || nc >= N) continue;
			if (map[nr][nc].equals("G")) {
				return true;
			}
		}
		return false;

	}
	
	public static int countB(String pos) {
		int sum = 0;
		for(int i=0; i<N; i++) {
			if(map[r][i].equals("B")) sum++;
		}
		for(int i=0; i<N; i++) {
			if(map[i][c].equals("B")) sum++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		// 테스트케이스를 돌면서 코드 실행
		for (int i = 0; i < T; i++) {
			// 배열의 크기 N 저장.
			int N = in.nextInt();
			// map에 각 문자 저장.
			String[][] map = new String[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = in.next();
				}
			}
			// map의 구역을 하나씩 돌면서,
			int[] sumArray = new int[N*N];
			int idx = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 만약에 해당 문자가 B이면
					if (!(map[r][c].equals("G"))) {
						// 인접구역에 G가 있는지 확인
						if (hasGreen(map[r][c])) {
							continue;
						} else {
							//G가 없으면 그 칸을 기준으로 좌, 우 돌면서 B 카운트.
							sumArray[idx++] = countB(map[r][c]);
						}
					}
				}
			}
			Arrays.sort(sumArray);
			System.out.println(sumArray[N*N-1]);
		}
		
		
	}

}
