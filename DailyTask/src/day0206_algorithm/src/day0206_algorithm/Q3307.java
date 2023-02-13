package day0206_algorithm;

import java.util.Scanner;

public class Q3307 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in) {
			int T = in.nextInt();
			for(int t=0; t<T; t++) {
				int n = in.nextInt();
				int[] array = new int[n];
				//array 배열에 수열 넣어주기.
				for(int i=0; i<n; i++) {
					array[i] = in.nextInt();
				}
			}
		}
	}
}
