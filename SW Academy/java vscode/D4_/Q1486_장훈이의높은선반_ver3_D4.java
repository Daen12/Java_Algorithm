package solving_club;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1486_장훈이의높은선반_ver3_D4 {
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
			int rs = 0; //모든 점원의 키의 합
			for(int i=0; i<N; i++) {
				heights[i] = in.nextInt();
			}
			powerSet(0, 0, 0);
			System.out.printf("#%d %d\n", t, result-B);
		}
	}
	//rsum : 앞으로 남은 (더해질 수 있는 합)
	public static void powerSet(int depth, int sum, int rsum) {
		if(sum>result) return; //계산하는 중간에서 이미 sum이 저장된 합의 최소를 넘어섰다면
		//리턴해주기!(해당 케이스 종료)
		if(depth == N) { //직원들 골랐으면 고른 키가 스택에 들어있음.
			if(sum>=B) {
				result = Math.min(result, sum);
			}
			return;
		}
		if(sum + rsum < B) return;//지금까지 더해진 합과 앞으로 남은 합을 더해도 B에 못미치면 그냥 리턴해주기
//		stack.push(heights[depth]);
		powerSet(depth+1, sum+heights[depth], rsum-heights[depth]); //depth를 더하는 경우
//		stack.pop();
		powerSet(depth+1, sum, rsum); //건너뛰고 다음꺼 더하는 경우
	}
}
