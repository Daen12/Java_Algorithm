package solving_club;

import java.util.Scanner;

public class Q1592_영식이와친구들_bronze2 {
	public static void main(String[] args) {
		//N이 홀수, L이 홀수일때 
		//N번 돌면 처음 자리로 돌아온다.
		//처음 자리가 현재 받은 횟수가 홀수번째이면 시계
		//현재 받은 횟수가 짝수번째이면 반시계
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //15
		int M = in.nextInt(); //4
		int L = in.nextInt(); //9.
		int round = 0;

		//N과 L의 최대공약수 구하기! 
		//round = N/최대공약수
		int GCD = 0;
		for(int i=1; i<=N && i<=L; i++) { 
			//숫자가 증가하므로 매 루프 최대 갱신!
			if(N%i==0 && L%i==0) {
				GCD = i;
			}
		}
		round = N/GCD;
		System.out.println(round*(M-1));
	}
}





