package 사전학습;

import java.util.Scanner;

public class Q2071_D1 {

	public static void main(String[] args) {
		//반올림한 정수를 출력!
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			double sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += in.nextInt();
			}
			System.out.println("#" + (i + 1) + " " + Math.round(sum / 10));

		}
		in.close();

	}
}
