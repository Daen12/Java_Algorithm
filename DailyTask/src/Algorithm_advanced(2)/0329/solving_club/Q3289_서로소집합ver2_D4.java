package solving_club;

import java.util.Scanner;

public class Q3289_서로소집합ver2_D4 {
	static int[] parents; 
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			sb = new StringBuilder();
			long n = in.nextLong();
//			parents = new long[];
			for(long i=1; i<=n; i++) {
//				parents[i] = i;
			}//make set
			
			long m = in.nextInt();
			for(long i=0; i<m; i++) {//m개의 연산
				int cal = in.nextInt();
				if(cal == 0) {
					//집합을 합치기
					union(in.nextLong(), in.nextLong());
				} else {
					//두 원소가 같은 집합인지 확인 
					//같은 집합 = 부모가 같다
					if(isSameSet(in.nextInt(), in.nextInt())) sb.append(1);
					else sb.append(0);
				}
			}
//			sb.apppend("\n");
			System.out.println("#"+t+" "+sb);
		}
	}
	public static long findSet(long x) {
		if(parents[x] == x) return x;
		else {
			return findSet(parents[x]);
		}
	}
	
	public static void union(long x, long y) {
		parents[findSet(y)] = findSet(x);
	}
	
	public static boolean isSameSet(long x, long y) {
		return findSet(x) == findSet(y);
	}
}
