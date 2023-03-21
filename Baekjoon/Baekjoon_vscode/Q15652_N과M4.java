package solving_club;

import java.util.Scanner;

public class Q15652_N과M4 {
	//같은 수를 여러번 골라도 됨.
	//비내림차순.
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt(); //4
		M = in.nextInt(); //2
		arr = new int[M];
		backTracking(0);
		System.out.println(sb);
	}
	
	public static void backTracking(int idx) {
		if(idx == M) {
			boolean isGood = true; //i=0,1
			for(int i=0; i<M-1; i++) { //3 3 1
				if(arr[i] > arr[i+1]) {
					isGood = false;
				}
			}
			if(isGood) {
				for(int i=0; i<M; i++) {
					sb.append(arr[i] + " ");
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=1; i<=N; i++) {
			arr[idx] = i;
			backTracking(idx+1);
		}
	}
}
