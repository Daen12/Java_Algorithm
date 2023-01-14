package 사전학습;


import java.util.Scanner;

public class Q1936_D1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();

		String[] array = new String[4];
		array[A] = "A";
		array[B] = "B";

		if ((A == 1 || B == 1) && (A == 3 || B == 3)) {
			System.out.println(array[Math.min(A, B)]);
		} else {
			System.out.println(array[Math.max(A, B)]);

		}
		in.close();
	}
}
