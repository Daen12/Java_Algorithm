package solving_club;

import java.util.Scanner;

public class Q1182_부분수열의합_silver2 {
	static int[] nums;
	static int S;
	static int N;
	static int count;
	static int cnt;
	//조합을 구해서 더하는 문제.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		S = in.nextInt();
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = in.nextInt();
		}
		count = 0;//매 테케마다 셀때 0으로 초기화
		cnt = 0;
		combination(0, 0);
		System.out.println(count);
	}
	static void combination(int idx, int sum) {
		
//		System.out.println(cnt);
		if(idx == N) {//인덱스 3까지 간 후 +1해서 4가 호출되었다면
			cnt++;
			if(sum == S && cnt!=Math.pow(2, N)) {//합이 S와 같다면 & 공집합이 아닌 경우
				count++;
			}
			//합이 S와 같지 않으면 if문에 안걸림. --> 그냥 리턴
			return; //돌아가
		}
		combination(idx+1,sum+nums[idx]); //더하는 경우
		combination(idx+1, sum); //안더하는 경우
	}
//	
}
