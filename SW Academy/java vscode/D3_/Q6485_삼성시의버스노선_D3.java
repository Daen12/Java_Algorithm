package solving_club;

import java.util.Scanner;

public class Q6485_삼성시의버스노선_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();
			int[] count = new int[5001];
			for(int i=0; i<N; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				for(int j=A; j<=B; j++) {
					count[j]++;
				}
			}
			System.out.print("#"+t+" ");
			int P = in.nextInt();
			for(int p=0; p<P; p++) {
				System.out.print(count[in.nextInt()]+" ");
			}
			
		}
	}
}
