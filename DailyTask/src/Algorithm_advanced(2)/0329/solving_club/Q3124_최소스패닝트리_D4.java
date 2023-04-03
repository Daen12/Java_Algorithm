package solving_club;

import java.util.Scanner;

public class Q3124_최소스패닝트리_D4 {
	static class Edge{
		long st, ed, c;
		public Edge(long st, long ed, long c) {
			this.st = st;
			this.ed = ed;
			this.c = c;
		}
	}
	
	static Edge[] edges;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			int V = in.nextInt();
			int E = in.nextInt();
			
			edges = new Edge[E];
			for(int i=0; i<E; i++) {
				edges[i] = new Edge(in.nextLong(), in.nextLong(), in.nextLong());
			}
		}
	}
	
//	public static int findset(int x) {
//		
//	}
}
