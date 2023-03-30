package solving_club;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q7465_창용마을무리의개수_D4 {
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int N = in.nextInt();//노드 수
			int M = in.nextInt();//간선의 개수
			parents = new int[N+1];//사람수는 1번부터
			for(int i=0; i<N+1; i++) {
				parents[i] = i;
			}//0-6까지 정수 저장
			System.out.println(Arrays.toString(parents));

			for(int i=0; i<M; i++) {
				int st = in.nextInt();
				int ed = in.nextInt();
				union(st, ed);//연결된 정보 parent에 저장.
			}
			System.out.println(Arrays.toString(parents));

			for(int i=0; i<N+1; i++) {
				findSet(i);//한번 더 돌려주기
			}
			System.out.println(Arrays.toString(parents));
			
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<N+1; i++) {
				set.add(parents[i]);
			}
			System.out.printf("#%d %d\n", t, set.size());
		}
	}
	static int findSet(int x) {
		if(parents[x] != x) {
			parents[x] = findSet(parents[x]);
		}
		return parents[x];
	}
	static void union(int x, int y) {
		parents[findSet(y)] = findSet(x);
	}
}
