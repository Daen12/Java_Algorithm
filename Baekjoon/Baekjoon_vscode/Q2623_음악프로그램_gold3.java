import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q2623_음악프로그램_gold3 {

	static List<Integer>[] graph;
	static int[] inD;
	static int N;
	static Queue<Integer> queue;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();//몇명
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();//초기화
		}
		inD = new int[N+1];
		visited = new boolean[N+1];
		int M = in.nextInt();//입력 수
		for(int i=0; i<M; i++) {
			int t = in.nextInt();
			int[] list = new int[t];
			for(int j=0; j<t; j++) {
				list[j] = in.nextInt();
			}//리스트에 담기
			for(int j=0; j<t-1; j++) {
				graph[list[j]].add(list[j+1]);
				inD[list[j+1]]++;
			}
		}
//		for(List i : graph) {
//			System.out.print(i + " ");
//		}
//		System.out.println(Arrays.toString(inD));
		sb= new StringBuilder();
		queue = new LinkedList<Integer>();
		TopSort();
//		System.out.println(Arrays.toString(visited));
		boolean isCycle = false;
		for(int i=1; i<N+1; i++) {
			if(visited[i] == false) {
				isCycle = true;
			}
		}
		if(isCycle) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}
	public static void TopSort() {
		for(int i=1; i<N+1; i++) {
			if(inD[i]==0) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node + "\n");
			for(int n : graph[node]) {
				inD[n]--;
				if(inD[n] == 0) {
					queue.offer(n);
					visited[n] = true;
				}
			}
		}
	}
}
