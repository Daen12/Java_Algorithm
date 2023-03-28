package solving_club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q보호필름_ver6_D4 {
	static int[][] Films;
	static int[][] FilmCopy;
	static int R, C, K;
	static int min;
	static int[] A;
	static int[] B;
	static int[] idxCopy;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			R = in.nextInt(); //6
			C = in.nextInt(); //8
			K = in.nextInt();
			Films = new int[R][C];
			
			A = new int[C];
			B = new int[C];
			
			for(int i=0; i<C; i++) {
				B[i] = 1;
			}
			idxCopy = new int[C];

			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					Films[r][c] = in.nextInt();
				}
			}
			min = Integer.MAX_VALUE;

			backTracking(0,0); //배열에 가능한 부분집합 넣어주기.
//			System.out.println(check());
		
			System.out.printf("#%d %d\n", t, min);
		}
	}

	public static void backTracking(int idx, int cnt) {
		if(min<=cnt) return;//1. 최소 바꾼 수가 cnt를 넘어가면 리턴(이후 수행할 필요 없음)
		//몇번 바꿨는지 = cnt
		//2. 체크 조건 "통과하면" -> 최소 바꾼 수 업데이트
		if(check()) min = Math.min(cnt, min);
		if(idx == R) return; //3.depth가 행끝까지 도달하면 -> 리턴
//		if(idx == R) {
//			//성능검사
//			if (check()) {// 만약 성능검사 통과하면, 바꾼 행의 수만큼 카운트에 더하기
//				min = cnt < min ? cnt : min;
//			}
//			return;
//		}

		int[] idxCopy = Films[idx];
		backTracking(idx+1, cnt);
		
		injection(idx, A); //A를 주입
		backTracking(idx+1, cnt+1);
		
		injection(idx, B);//B를 주입
		backTracking(idx+1, cnt+1);

		restore(idx, idxCopy);
	}

	private static void injection(int idx, int[] chem) {
		Films[idx] = chem;
	}
	
	private static void restore(int idx, int[] idxCopy) {
		Films[idx] = idxCopy;
	}
	
	public static boolean check() {//3
//		int colComplete = 0;
		for(int r=0; r<C; r++) {//4
			int flag = -1;
			int countA = 0;
			int countB = 0;
			for(int c=0; c<R; c++) {//6
				if(c==0) {
					flag = Films[0][r];
				}
				if(flag != Films[c][r]) {
					countA = 0;
					countB = 0;
					flag = Films[c][r];
				}
				if(Films[c][r] == 0 && flag == 0) {
					countA++;
					if(countA == K) {
//						colComplete++;
						break;
					}
				} else if(Films[c][r] == 1 && flag == 1){
					countB++;
					if(countB==K) {
//						colComplete++;
						break;
					}
				} 
				
			}
			if(Math.max(countA, countB)<K) {
				return false;
			}
		}
		return true;
		//만약 colComplete의 값이 칼럼개수와 일치하면 모두 통과한것이므로 리턴 true
//		if(colComplete == C) {
//			return true;
//		} else {
//			return false;
//		}
	}
}
