package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10163_색종이_bronze1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] C = new int[T];
		int[] R = new int[T];
		int[] x = new int[T];
		int[] y = new int[T];
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C[t] = Integer.parseInt(st.nextToken());
			R[t] = Integer.parseInt(st.nextToken());
			x[t] = Integer.parseInt(st.nextToken());
			y[t] = Integer.parseInt(st.nextToken());
			
		}
		//여기까지 배열화
		int[][][] maps = new int[T][1001][1001];
		for(int t=0; t<T-1; t++) {
			//새로운 맵 생성
			int[][] map = new int[1001][1001];
			//t와 t+1을 보면서 계산! 
			//t에 해당하는 좌표들 1로 채워주기
			for(int r=R[t]; r<R[t]+y[t]; r++) {
				for(int c=C[t]; c<C[t] + x[t]; c++) {
					map[r][c] = 1;  
				}
			}
			//t+1에 해당하는 좌표들 1이면 0으로 바꿔주기
			for(int r=R[t+1]; r<R[t+1]+y[t+1]; r++) {
				for(int c=C[t+1]; c<C[t+1] + x[t+1]; c++) {
					if(map[r][c] == 1) {
						map[r][c] = 0;
					} else {
						map[r][c] = 1;
					}
				}
			}
		}
		//각각 따로따로 보기!
		for(int t=0; t<T; t++) {
			int Sum = 0;
			for(int r=R[t]; r<R[t]+y[t]; r++) {
				for(int c=C[t]; c<C[t] + x[t]; c++) {
					Sum+=map[r][c];
				}
			}
			System.out.println(Sum);
		}
		
		
	}
}
