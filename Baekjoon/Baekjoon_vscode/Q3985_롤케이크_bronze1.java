package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class Q3985_롤케이크_bronze1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int[] cake = new int[L];
		int T = in.nextInt();
		for(int t=T; 1<=T; t--) {
			int from = in.nextInt();
			int to = in.nextInt();
			Arrays.fill(cake, from, to+1, t);
		}
		System.out.println(Arrays.toString(cake));
		
	}
}
