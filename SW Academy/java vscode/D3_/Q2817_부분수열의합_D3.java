package solving_club;

import java.util.Scanner;

public class Q2817_부분수열의합_D3 {
//	static int[] nums; //{1,2,1,2}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt(); //4
			int K = in.nextInt(); //3
			int[] nums = new int[N];
			//부분수열 만들기
			for(int i=0; i<N; i++) {
				nums[i] = in.nextInt();
			}
			int count = 0;
			for(int i=0; i<(1<<N); i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					//j는 0부터 3까지
					if((i & (1<<j)) > 0) {
						sum+=nums[j];
					}
				}
				//만약 다 더한 값이 K와 같으면 count++;
				if(sum == K) count++;
			}
			
			System.out.printf("#%d %d\n", t, count);
		}
	}
}
