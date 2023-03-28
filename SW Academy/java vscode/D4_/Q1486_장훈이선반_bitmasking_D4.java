package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1486_장훈이선반_bitmasking_D4 {
	//직원들의 키 powerset으로 구한후 더하기
	//이 값이  B보다 큰지 확인
	//만약 크면 기존의 값보다 작은지 확인
	//작으면 그걸로 정답 갱신
	
	static int[] heights;
	static int B;
	static int N;
	static int result;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			N = in.nextInt();
			B = in.nextInt();
			result = Integer.MAX_VALUE;
			heights = new int[N];
			for(int i=0; i<N; i++) {
				heights[i] = in.nextInt();
			}
			
			for(int i=0; i<(1<<N); i++) {//N은 몇명인지/모든 부분집합을 돌아보기
				int sum = 0;
				for(int j=0; j<N; j++) {//몇번째 점원?
					if((i & (1<<j))>0) {//해당 점원이 i번째 부분집합에 있는지.
						//있으면 그 점원의 키를 sum에 더하기
						sum+=heights[j];
					}
				}
				if(sum>=B && sum< result) {
					result = sum;
					result = Math.min(sum, result);
				}
			}
			System.out.printf("#%d %d\n", t, result-B);
		}
	}
}
