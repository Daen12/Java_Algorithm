package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class 배열2_실습2_ver1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] soil = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				soil[r][c] = sc.nextInt();
			}
		}

		int[] nutrient = new int[N * N];
		// 상, 하, 좌, 우, 현재위치 인덱스 만들기
		int[] dr = { -1, 1, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0 };

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				//각 인덱스에 대해서 주변 5개 값을 더한 후  
				//nutrient 배열에 저장
				int sum = 0;
				for (int i = 0; i < 5; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
						continue;
					}else{
						sum += soil[nr][nc];
					}
				}
				nutrient[N * r + c] = sum;
			}
		}

		Arrays.sort(nutrient);
		System.out.println(nutrient[N * N - 1]);

	}

}

