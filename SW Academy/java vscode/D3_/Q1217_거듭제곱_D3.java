package solving_club;

import java.util.Scanner;

public class Q1217_거듭제곱_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int T = in.nextInt();
			int C = in.nextInt();
			int N = in.nextInt();
			
			int result = pow(C,N);
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
	
	public static int pow(int C, int N) {
	
		if(N ==1)return C;
		
		if(N%2 == 0) {
			return pow(C, N/2)*pow(C, N/2);
		} else {
			return pow(C, (N-1)/2)*pow(C, (N-1)/2)*C;
		}
	}
}
