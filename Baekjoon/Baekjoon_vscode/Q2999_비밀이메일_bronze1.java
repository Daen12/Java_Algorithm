package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q2999_비밀이메일_bronze1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] input = in.next().toCharArray();
		int N = input.length;
		// R*C = N 이며 R<=C인 R, C를 구하기
		// 여러개면 R이 큰 값을 선택하기.
		int R = 1, C = N;
		int tempR = 1;
		int tempC = N; // 8
		while (tempR <= tempC) {
			tempR++; // 3
			if (N % tempR == 0) {
				tempC = N / tempR; // 4
				// 해당하는 값들을 R과 C에 영구저장!
				if (tempR <= tempC) {
					C = tempC;
					R = tempR;
				}
			}
		}
		char[][] message = new char[R][C];
		int m = 0;
		// 처음 받을때 열을 늘려가며 읽기
		for (int r = 0; r < C; r++) {
			for (int c = 0; c < R; c++) {
				message[c][r] = input[(m++) % N];
			}
		}
		// message배열을 가로로 읽으며 출력!
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(message[r][c]);
			}
		}

	}
}
