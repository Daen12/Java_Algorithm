package solving_club;

import java.util.Arrays;
import java.util.Scanner;

public class J_Q1037_오류교정 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		boolean parity = true;
		int[][] map = new int[N][N];
		int[] R = new int[N];
		int[] C = new int[N];
		
		for(int r=0; r<N; r++) {
			int checkEven = 0; //각 row에 대한 짝수 체크
			for(int c=0; c<N; c++) {
				map[r][c] = in.nextInt();
				checkEven+=map[r][c]; 
				if(c==N-1) {//마지막 인덱스에서
					if(checkEven %2 !=0) parity = false; //checkEven이 짝수가 아니면 false
					R[r] = checkEven;
				}
			}
		}
		for(int r=0; r<N; r++) {
			int checkEven = 0;
			for(int c=0; c<N; c++) {
				checkEven+=map[c][r]; 
				if(c==N-1) {
					if(checkEven %2 !=0) parity = false; //checkEven이 짝수가 아니면 false
					C[r] = checkEven;
				}
			}
		}

		//만약 parity = true이면 OK 출력
		//만약 하나를 바꿔서 parity 가능하면 Change 
		//아니면 Corrupt 출력
		if(!parity) { 
			int Rcount = 0;
			int Ridx = 0;//하나씩 홀수가 나와야함.
			int Ccount = 0;
			int Cidx = 0;
			for(int i=0; i<N; i++) {
				if(R[i]%2!=0) {
					Rcount++;
					Ridx = i+1;
				}
				if(C[i]%2!=0) {
					Ccount++;
					Cidx = i+1;
				}
			}
			if(Rcount==1 && Ccount == 1) {
				System.out.printf("Change bit (%d,%d)\n", Ridx, Cidx);
			} else {
				System.out.println("Corrupt");
			}
		} else {
			System.out.println("OK");
		}
	}
}
