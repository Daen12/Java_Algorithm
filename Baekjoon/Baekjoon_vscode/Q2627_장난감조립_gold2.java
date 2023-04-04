import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q2627_장난감조립_gold2 {
	static List<Integer>[] graph;
	static int[] inD, count;
	static int N, ans;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();// 몇번노드까지
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();// 초기화
		}
		inD = new int[N + 1];
		count = new int[N+1];
		//입력받기
		int M = in.nextInt();
		for(int i=0; i<M; i++) {
			int st = in.nextInt();
			int ed = in.nextInt();
			inD[ed]++;
			graph[st].add(ed);
			count[ed] = in.nextInt();
		}
		ans = 0;
		TopSort();
		System.out.println();
	}

	public static void TopSort() {
		for (int i = 1; i < N + 1; i++) {
			if (inD[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int n : graph[node]) {
				inD[n]--;
				if (inD[n] == 0) {
					queue.offer(n);
				}
			}
		}
	}
}