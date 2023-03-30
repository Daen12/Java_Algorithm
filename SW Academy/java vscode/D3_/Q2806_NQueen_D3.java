package solving_club;

import java.util.Scanner;

public class Q2806_NQueen_D3 {
	static int N, R, C, cnt;
	static int[] QueenCols;
	
	public static void main(String[] args) {
		//찾은 경우에 대해서 조건을 달아서 인터셉트 = 백트래킹
		//모든 경우의 수를 고려하지 않아도 됨.
		//4P4에 조건을 단 형태와 같음!
		
		//N이 주어졌을떄. 퀸을 놓는 방법의 수 구하기
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=1; t++) {
			N = in.nextInt();
			cnt = 0;
			QueenCols = new int[N];
			backTracking(0);
			System.out.printf("#%d %d\n", t, cnt);
		}
	}

	private static void backTracking(int R) {
		if(R == N) {//만약 경우의 수를 하나 찾으면 
			cnt++; //카운트 증가
			return;
		}
		
		for(int i=0; i<N; i++) {//순열느낌
			QueenCols[R] = i;//0번째 행에-> 칼럼0에 놓는 경우부터 시작.
			if(check(R)) {
				backTracking(R+1);
			}
		}
	}
	private static boolean check(int R) {
		for(int i=0; i<R; i++) { //행R전까지 보면서
			//칼럼은 안겹침.
			//행이 겹치는지 / 대각선이 겹치는지만 보면 됨
			if(QueenCols[R] == QueenCols[i] || QueenCols[i]+i == QueenCols[R]+R || QueenCols[i]-i == QueenCols[R]-R) {
				return false;
			}
		}
		return true;
	}
}
