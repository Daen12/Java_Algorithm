package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class 배열2_과제2_ver1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] map = new int[N][N];

		// 지도 생성하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = in.nextInt();
			}
		}
		// 위, 아래, 왼쪽, 오른쪽
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// maxList는 각 인덱스 기준 사방으로 놓는 다리의 최댓값의 모임.
		int[] maxList = new int[N * N];
		// 각 위치에 대하여
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 만약 현재 위치가 섬이라면
				if (map[r][c] == 1) {
					// countList는 해당 인덱스에서 각 방향에 대한 count들의 모임.
					int[] countList = new int[4];
					

					// 상하좌우에 대해 count수를 countList에 순서대로 추가
					for (int i = 0; i < 4; i++) {
						int count = 0;
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
							continue;
						}
						// 해당 방향에 대해 바다가 나오면 계속 count증가.
						while (true) {
							if (map[nr][nc] == 0) {
								count++;
								nr += dr[i];
								nc += dc[i];
								if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
									break;
								}

							} else {
								break;
							}
						}
						countList[i] = count+1;
					}
					// countList의 최댓값을 산출해서 maxList에 추가
					Arrays.sort(countList);
					maxList[N * r + c] = countList[3];
				} else {
					maxList[N * r + c] = 0;
				}
			}
			
		}
		Arrays.sort(maxList);
		System.out.println(maxList[N*N-1]);
	}
}
