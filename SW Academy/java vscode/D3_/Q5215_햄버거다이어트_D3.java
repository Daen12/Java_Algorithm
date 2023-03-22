package solving_club;

import java.util.Scanner;

public class Q5215_햄버거다이어트_D3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt(); //5
			int L = in.nextInt(); //1000 calorie limit
			
			int[] score = new int[N];
			int[] calorie = new int[N];
			int maxScore = 0;
			for(int i=0; i<N; i++) {
				score[i] = in.nextInt();
				calorie[i] = in.nextInt();
			}
			
			for(int i=0; i<(1<<N); i++) {//모든 조합의 경우. 예시에서는 32개
				int totalCal = 0;
				int totalScore = 0;
				for(int j=0; j<N; j++) { //각 인덱스의 재료가 들어가는지
					if((i & (1<<j)) > 0) { //겹치는 재료가 있으면
						totalCal += calorie[j];
						totalScore += score[j];
					}
				}
				//재료 선택 round 후
				//만약 칼로리가 limit을 넘지 않는다면 해당 스코어가 max보다 큰지 확인, 크면 swap
				if(totalCal <= L) {
					maxScore = maxScore < totalScore? totalScore : maxScore;
				}
			}
			System.out.printf("#%d %d\n", t, maxScore);
		}
	}
}
