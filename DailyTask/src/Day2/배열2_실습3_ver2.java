package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class 배열2_실습3_ver2 {

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
			// 각 인덱스 기준 B의개수 합이 들어갈 배열
			int[] sumArray = new int[N * N];
			// map의 구역을 하나씩 돌면서,
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 만약에 해당 문자가 B이면
					if (map[r][c].equals("B")) {
						// 인접구역에 G가 있는지 확인
						int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
						int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
						boolean hasGreen = false;
						for (int j = 0; j < 8; j++) {
							int nr = r + dr[j];
							int nc = c + dc[j];
							// 예외처리
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							// 인접구역에 G가 있으면 다음 인덱스로 넘어가기
							if (map[nr][nc].equals("G")) {
								hasGreen = true;
							}

						}
						// G가 없으면 그 칸을 기준으로 좌, 우 돌면서 B 카운트. 자신의 인덱스는 두번 카운트하므로 마지막 1 빼기.
						if (!hasGreen) {
							int sum = 0;
							for (int k = 0; k < N; k++) {
								if (map[r][k].equals("B"))
									sum++;
							}
							for (int t = 0; t < N; t++) {
								if (map[t][c].equals("B"))
									sum++;
							}
							sumArray[N * r + c] = sum - 1;
						} 
					}
				}
			}
			Arrays.sort(sumArray);
			//i번째 답을 공백 사이에 두고 프린트
			System.out.println("#"+(i+1)+" "+sumArray[N * N - 1]);
		}

	}

}
