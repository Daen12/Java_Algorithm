package solving_club;

import java.util.Scanner;

public class Q3289_서로소집합_D4 {
	static int[] parents; 
//	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			System.out.print("#"+t+" ");
			int n = in.nextInt();
			parents = new int[n+1];
			for(int i=1; i<=n; i++) {
				parents[i] = i;
			}//make set
			
			int m = in.nextInt();
			for(int i=0; i<m; i++) {//m개의 연산
				int cal = in.nextInt();
				if(cal == 0) {
					//집합을 합치기
					union(in.nextInt(), in.nextInt());
				} else {
					//두 원소가 같은 집합인지 확인 
					//같은 집합 = 부모가 같다
					if(isSameSet(in.nextInt(), in.nextInt())) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	public static int findSet(int x) {
		if(parents[x] == x) return x;
		else {
			return findSet(parents[x]);
		}
	}
	
	public static void union(int x, int y) {
		parents[findSet(y)] = findSet(x);
	}
	
	public static boolean isSameSet(int x, int y) {
		return findSet(x) == findSet(y);
	}
}
