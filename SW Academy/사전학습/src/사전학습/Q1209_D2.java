package 사전학습;

import java.util.Arrays;
import java.util.Scanner;

public class Q1209_D2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int n = 0; n < 10; n++) {
			int name = sc.nextInt();

			// 100줄을 돌면서 각 줄을 배열에 담는다. (=배열이 총 100개)
			int[][] master = new int[100][100];
			int[] rowSum = new int[100];
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					master[i][j] = sc.nextInt();
					sum += master[i][j];
				}
				rowSum[i] = sum;
			}
			// 각 행의 합, 열의 합, 대각선의 합 담을 배열 만들기
			int[] columnSum = new int[100];

			// 열의 합 (=각 이중배열의 맨앞 ~ 맨뒤 숫자끼리 합)
			for (int i = 0; i < 100; i++) {
				int column = 0;
				for (int j = 0; j < 100; j++) {
					column += master[j][i];
				}
				columnSum[i] = column;
			}
			// 대각선의 합
			int[] diagonalSum = new int[2];
			int firstDiagonal = 0;
			int secondDiagonal = 0;
			for (int i = 0; i < 100; i++) {
				firstDiagonal += master[i][i];
				secondDiagonal += master[99 - i][99 - i];
			}

			diagonalSum[0] = firstDiagonal;
			diagonalSum[1] = secondDiagonal;

			// 모든 배열 세개 합치기
			// arraycopy : (추가시킬 배열, 인덱스(0), 추가될배열, 인덱스(0,어디서부터 할), 추가할길이(len))
			int[] totalArray = new int[rowSum.length + columnSum.length + diagonalSum.length];
			System.arraycopy(rowSum, 0, totalArray, 0, 100);
			System.arraycopy(columnSum, 0, totalArray, 100, columnSum.length);
			System.arraycopy(diagonalSum, 0, totalArray, 200, diagonalSum.length);

			// 다 합친 배열에서 가장 큰 수가 정답.
			Arrays.sort(totalArray);
			int max = totalArray[201];

			System.out.println("#" + name + " " + max);

		}
	}

}
